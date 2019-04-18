package pers.lyning.kata.countdowntimer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pers.lyning.kata.testing.SystemOutputCapture;

import java.util.concurrent.Future;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class CountdownTest {

    @Rule
    public final ExpectedException expectedEx = ExpectedException.none();
    @Rule
    public final SystemOutputCapture outputCapture = SystemOutputCapture.init();

    @Test
    public void should_not_running() {
        Consumer<String> tick = a -> System.out.println(a);
        Countdown countdown = new Countdown(10, tick);
        assertThat(countdown.isRunning()).isFalse();
    }

    @Test
    public void should_running() {
        Consumer<String> tick = a -> System.out.println(a);
        Countdown countdown = new Countdown(10, tick);
        countdown.start();
        assertThat(countdown.isRunning()).isTrue();
    }

    @Test
    public void should_destroyed() {
        Consumer<String> tick = a -> System.out.println(a);
        Countdown countdown = new Countdown(10, tick);
        countdown.start();
        countdown.destroy();
        assertThat(countdown.isRunning()).isFalse();
    }

    @Test
    public void should_called_tick() {
        Consumer tick = out -> System.out.println("called");
        Countdown countdown = new Countdown(1, tick);
        Future future = countdown.start();
        while (!future.isDone()) {
            assertThat(countdown.isRunning()).isTrue();
        }

        assertThat(outputCapture.toString()).contains("called");
    }

    @Test(timeout = 3000)
    public void should_timeout_error() {
        expectedEx.expect(Exception.class);

        Consumer tick = out -> System.out.println("called");
        Countdown countdown = new Countdown(4, tick);
        Future future = countdown.start();
        while (!future.isDone()) {
            assertThat(countdown.isRunning()).isTrue();
        }
    }

    @Test(timeout = 3000)
    public void should_countdown_3_seconds() {
        Consumer tick = out -> System.out.println("called");
        Countdown countdown = new Countdown(3, tick);
        Future future = countdown.start();
        while (!future.isDone()) {
            assertThat(countdown.isRunning()).isTrue();
        }
    }

    private void untilCompletionFor(Future future) {
        while (!future.isDone()) {
            future.isDone();
        }
    }
}
