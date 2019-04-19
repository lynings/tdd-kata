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
        this.scheduledFuture = this.scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            forward();
            if (this.second <= 0) {
                stopCallback.call("");
            }
        }, 0, second, TimeUnit.SECONDS);
        return this.scheduledFuture;
    }

    private void forward() {
        if (this.second > 0) {
            this.second -= 1;
            this.tick.call("");
        }
    }
}
