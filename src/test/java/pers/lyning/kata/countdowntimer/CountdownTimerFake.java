package pers.lyning.kata.countdowntimer;

import com.google.common.util.concurrent.Futures;
import javafx.util.Callback;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author lyning
 */
public class CountdownTimerFake extends CountdownTimer {

    private volatile long period;
    private Callback callback;
    private Future future;

    @Override
    public Future schedule() {
        future = Futures.immediateCancelledFuture();
        return this.future;
    }

    public CountdownTimerFake(Callback callback, long period, TimeUnit unit) {
        super(callback, period, unit);
        this.callback = callback;
        this.period = period;
    }

    public void forward() {
        this.period -= 1;
        this.callback.call("");
        if (this.period <= 0) {
            this.future.cancel(true);
        }
    }
}
