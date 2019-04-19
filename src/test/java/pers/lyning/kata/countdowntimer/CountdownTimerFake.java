package pers.lyning.kata.countdowntimer;

import com.google.common.util.concurrent.Futures;

import java.util.concurrent.Future;

/**
 * @author lyning
 */
public class CountdownTimerFake extends CountdownTimer {

    private long second;
    private final Runnable tick;
    private Future timerFuture;
    private Runnable stopCallback;

    public CountdownTimerFake(Runnable tick, long second) {
        super(tick, second);
        this.tick = tick;
        this.second = second;
    }

    @Override
    public Future schedule(Runnable stopCallback) {
        this.stopCallback = stopCallback;
        this.timerFuture = Futures.immediateCancelledFuture();
        return this.timerFuture;
    }

    public void triggerReduceTime() {
        this.second -= 1;
        this.tick.run();
        if (this.second <= 0) {
            this.stop();
        }
    }

    @Override
    public long remainingTime() {
        return this.second;
    }

    private void stop() {
        this.stopCallback.run();
        this.timerFuture.cancel(true);
    }
}
