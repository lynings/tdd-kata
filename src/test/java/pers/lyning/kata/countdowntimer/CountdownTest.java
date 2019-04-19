package pers.lyning.kata.countdowntimer;

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
        Runnable tick = () -> System.out.println("tick called");
        this.countdown = new Countdown(10, tick);
        this.countdownTimerFake = new CountdownTimerFake(tick, 10);
        this.countdown.countdownTimer = this.countdownTimerFake;
    }

    @Test
    public void should_not_running() {
        assertThat(this.countdown.isRunning()).isFalse();
    }

    @Test
    public void should_running() {
        this.countdown.start();
        assertThat(this.countdown.isRunning()).isTrue();
    }

    @Test
    public void should_remaining_10_seconds() {
        this.countdown.start();
        assertThat(this.countdown.getRemainingTime()).isEqualTo(10);
    }

    @Test
    public void should_call_2_tick_and_remaining_8_seconds() {
        this.countdown.start();
        this.reduceTime(1);
        assertThat(this.outputCapture.toString().trim()).isEqualTo("tick called");
        this.reduceTime(1);
        assertThat(this.outputCapture.toString().trim()).isEqualTo("tick called\ntick called");
        assertThat(this.countdown.getRemainingTime()).isEqualTo(8);
    }

    @Test
    public void should_stopped_when_countdown_10_seconds() {
        this.countdown.start();
        this.reduceTime(10);
        assertThat(this.countdown.isRunning()).isFalse();
    }

    private void reduceTime(int seconds) {
        for (int second = 0; second < seconds; second++) {
            this.countdownTimerFake.reduceTime();
        }
    }
}
