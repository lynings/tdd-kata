package pers.lyning.kata.countdowntimer2;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Arrays;

public class TimerTest {

    StubClock stubClock = new StubClock();
    MockRunnable mockRunnable = new MockRunnable();

    @Test
    public void should_not_call_callback_when_count_down_is_0() {
        givenClockWithTicks(0, 1);

        timerWithCountDownSecond(0).start(mockRunnable);

        mockRunnable.verifyRunWithCount(0);
    }

    @Test
    public void should_call_callback_after_one_second() {
        givenClockWithTicks(0, 1);

        timerWithCountDownSecond(1).start(mockRunnable);

        mockRunnable.verifyRunWithCount(1);
    }

    @Test
    public void should_call_callback_after_more_than_seconds() {
        givenClockWithTicks(0, 1, 2);

        timerWithCountDownSecond(2).start(mockRunnable);

        mockRunnable.verifyRunWithCount(2);
    }

    @Test
    public void should_call_callback_until_one_second_arrives() {
        givenClockWithTicks(0, 0.5, 1);

        timerWithCountDownSecond(1).start(mockRunnable);

        mockRunnable.verifyRunWithCount(1);
    }

    @Test
    public void should_be_able_to_start_more_than_once() {
        givenClockWithTicks(0, 1, 2, 3);
        Timer timer = timerWithCountDownSecond(1);
        timer.start(mockRunnable);

        MockRunnable anotherMockRunnable = new MockRunnable();
        timer.start(anotherMockRunnable);

        anotherMockRunnable.verifyRunWithCount(1);
    }

    @Test
    public void should_call_callback_2_times_when_interval_more_than_one_second() {
        givenClockWithTicks(0, 1, 2.01);
        Timer timer = timerWithCountDownSecond(2);
        timer.start(mockRunnable);

        mockRunnable.verifyRunWithCount(2);
    }

    @Test
    public void acceptance_test() {
        new Timer(5).start(mockRunnable);

        mockRunnable.verifyRunWithCount(5);
    }

    private Timer timerWithCountDownSecond(int second) {
        return new Timer(second, stubClock);
    }

    private void givenClockWithTicks(double... ticksInMillis) {
        stubClock.setTicks(instantsOf(ticksInMillis));
    }

    private Instant[] instantsOf(double[] ticksInMillis) {
        return Arrays.stream(ticksInMillis).mapToObj(millis -> millisFromNow(Math.round(millis * 1000))).toArray(Instant[]::new);
    }

    private Instant millisFromNow(long millis) {
        return Instant.parse("2018-11-01T18:30:00Z").plusMillis(millis);
    }

}
