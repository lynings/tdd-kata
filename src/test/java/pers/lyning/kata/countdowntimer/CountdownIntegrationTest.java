package pers.lyning.kata.countdowntimer;

import javafx.util.Callback;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pers.lyning.kata.testing.SystemOutputCapture;

import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author lyning
 */
public class CountdownIntegrationTest {

    @Rule
    public final ExpectedException expectedEx = ExpectedException.none();
    @Rule
    public final SystemOutputCapture outputCapture = SystemOutputCapture.init();

    private final Callback tick = out -> {
        System.out.println("tick called");
        return out;
    };

    @Test
    public void should_called_tick() {
        Countdown countdown = new Countdown(1, tick);
        Future future = countdown.start();
        this.untilCompletedFor(future);
        assertThat(outputCapture.toString().trim()).isEqualTo("tick called");
    }

    @Test(timeout = 3000)
    public void should_stopped_when_countdown_2_seconds() {
        Countdown countdown = new Countdown(2, tick);
        Future future = countdown.start();
        this.untilCompletedFor(future);
        assertThat(countdown.isRunning()).isFalse();
    }

    private void untilCompletedFor(Future future) {
        while (!future.isDone()) {
            assertThat(future.isDone()).isFalse();
        }
    }
}

