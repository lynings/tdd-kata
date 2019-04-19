package pers.lyning.kata.countdowntimer;

import com.google.common.util.concurrent.Futures;
import javafx.util.Callback;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author lyning
 */
public class CountdownTimerFake extends CountdownTimer {

    private volatile long second;
    private final Callback callback;
    private Future future;

    @Override
    public Future schedule() {
        future = Futures.immediateCancelledFuture();
        return this.future;
    }

    public CountdownTimerFake(Callback callback, long period) {
        super(callback, period, TimeUnit.SECONDS);
        this.callback = callback;
        this.second = second;
    }

    public void forward() {
        this.second -= 1;
        this.callback.call("");
        if (this.second <= 0) {
            this.future.cancel(true);
        }
    }
}
