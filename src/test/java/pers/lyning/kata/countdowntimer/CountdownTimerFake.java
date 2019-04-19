package pers.lyning.kata.countdowntimer;

import com.google.common.util.concurrent.Futures;
import javafx.util.Callback;

import java.util.concurrent.Future;

/**
 * @author lyning
 */
public class CountdownTimerFake extends CountdownTimer {

    private volatile long second;
    private final Callback tick;
    private Future future;
    private Callback stopCallback;

    @Override
    public Future schedule(Callback stopCallback) {
        this.stopCallback = stopCallback;
        future = Futures.immediateCancelledFuture();
        return this.future;
    }

    public CountdownTimerFake(Callback tick, long second) {
        super(tick, second);
        this.tick = tick;
        this.second = second;
    }

    public void forward() {
        this.second -= 1;
        this.tick.call("");
        if (this.second <= 0) {
            this.stopCallback.call("");
            this.future.cancel(true);
        }
    }
}
