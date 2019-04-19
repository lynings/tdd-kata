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
    private long period;
    private final TimeUnit unit;
    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
    private ScheduledFuture<?> scheduledFuture;


    public CountdownTimer(Callback callback, long period, TimeUnit unit) {
        this.callback = callback;
        this.period = period;
        this.unit = unit;
    }

    public Future schedule() {
        this.scheduledFuture = this.scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            forward();
        }, 0, period, unit);
        return this.scheduledFuture;
    }

    private void cancel() {
        this.scheduledFuture.cancel(true);
    }

    private void forward() {
        this.period -= 1;
        this.callback.call("");
        if (this.period <= 0) {
            this.cancel();
        }
    }
}
