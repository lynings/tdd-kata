package pers.lyning.kata.countdowntimer;

import javafx.util.Callback;
import org.junit.Rule;
import org.junit.Test;
import pers.lyning.kata.testing.SystemOutputCapture;

import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author lyning
 */
public class CountdownIntegrationTest {

    @Rule
    public final SystemOutputCapture outputCapture = SystemOutputCapture.init();

    private final Runnable tick = () -> System.out.println("tick called");

    @Test
    public void should_called_tick() {
        Countdown countdown = new Countdown(1, tick);
        Future future = countdown.start();
        this.untilCompletedFor(future);
        assertThat(outputCapture.toString().trim()).isEqualTo("tick called");
    }

    @Test(timeout = 2100)
    public void should_stopped_when_countdown_2_seconds() {
        Countdown countdown = new Countdown(2, tick);
        Future future = countdown.start();
        this.untilCompletedFor(future);
        assertThat(countdown.isRunning()).isFalse();
        assertThat(countdown.getRemainingTime()).isEqualTo(0);
    }

    private void untilCompletedFor(Future future) {
        while (!future.isDone()) {
            assertThat(future.isDone()).isFalse();
        }
    }
}

