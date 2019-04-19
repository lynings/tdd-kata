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
    private final Callback callback;
    private long second;
    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
    private ScheduledFuture<?> scheduledFuture;


    public CountdownTimer(Callback callback, long second) {
        this.callback = callback;
        this.second = second;
    }

    public Future schedule(Callback stopCallback) {
        this.scheduledFuture = this.scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            forward();
            if (this.scheduledFuture.isDone()) {
                stopCallback.call("");
            }
        }, 0, second, TimeUnit.SECONDS);
        return this.scheduledFuture;
    }

    private void cancel() {
        this.scheduledFuture.cancel(true);
    }

    private void forward() {
        this.second -= 1;
        this.callback.call("");
        if (this.second <= 0) {
            this.cancel();
        }
    }
}
