package pers.lyning.kata.countdowntimer;

import javafx.util.Callback;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lyning
 */
public class CountdownTimer {
    private long second;
    private final Callback tick;
    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
    private ScheduledFuture<?> scheduledFuture;


    public CountdownTimer(Callback tick, long second) {
        this.tick = tick;
        this.second = second;
    }

    public Future schedule(Callback stopCallback) {
        final Runnable runnable = () -> {
            reduceTime();
            if (this.remainingTime() <= 0) {
                stopCallback.call("");
            }
        };
        this.scheduledFuture = this.scheduledThreadPoolExecutor.scheduleAtFixedRate(runnable, 0, second, TimeUnit.SECONDS);
        return this.scheduledFuture;
    }

    private void reduceTime() {
        if (this.second > 0) {
            this.second -= 1;
            this.tick.call("");
        }
    }

    public long remainingTime() {
        return this.second;
    }
}
