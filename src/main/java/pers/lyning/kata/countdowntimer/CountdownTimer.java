package pers.lyning.kata.countdowntimer;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lyning
 */
public class CountdownTimer {
    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
    private final Runnable tick;
    private long second;
    private ScheduledFuture<?> scheduledFuture;


    public CountdownTimer(Runnable tick, long second) {
        this.tick = tick;
        this.second = second;
    }

    public long remainingTime() {
        return this.second;
    }

    public Future schedule(Runnable stopCallback) {
        final Runnable runnable = () -> {
            this.triggerReduceTime();
            if (this.remainingTime() <= 0) {
                stopCallback.run();
            }
        };
        this.scheduledFuture = this.scheduledThreadPoolExecutor.scheduleAtFixedRate(runnable, 0, this.second, TimeUnit.SECONDS);
        return this.scheduledFuture;
    }

    private void triggerReduceTime() {
        if (this.second > 0) {
            this.second -= 1;
            this.tick.run();
        }
    }
}
