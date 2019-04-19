package pers.lyning.kata.countdowntimer;

import javafx.util.Callback;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pers.lyning.kata.testing.SystemOutputCapture;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class CountdownTest {

    @Rule
    public final SystemOutputCapture outputCapture = SystemOutputCapture.init();
    private Countdown countdown;
    private CountdownTimerFake countdownTimerFake;

    @Before
    public void setUp() throws Exception {
        Callback tick = (call) -> {
            System.out.println("tick called");
            return call;
        };
        this.countdown = new Countdown(10, tick);
        this.countdownTimerFake = new CountdownTimerFake(tick, 10);
        this.countdown.countdownTimer = this.countdownTimerFake;
    }

    @Test
    public void should_not_running() {
        assertThat(countdown.isRunning()).isFalse();
    }

    @Test
    public void should_running() {
        countdown.start();
        assertThat(countdown.isRunning()).isTrue();
    }

    @Test
    public void should_call_the_tick_once_every_second() {
        countdown.start();
        this.timeForward(1);
        assertThat(outputCapture.toString().trim()).isEqualTo("tick called");
        this.timeForward(1);
        assertThat(outputCapture.toString().trim()).isEqualTo("tick called\ntick called");
    }

    @Test
    public void should_stopped_when_countdown_10_seconds() {
        countdown.start();
        this.timeForward(10);
        assertThat(this.countdown.isRunning()).isFalse();
    }

    private void timeForward(int seconds) {
        for (int second = 0; second < seconds; second++) {
            this.countdownTimerFake.forward();
        }
    }
}
