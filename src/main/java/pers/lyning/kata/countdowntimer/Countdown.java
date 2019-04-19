package pers.lyning.kata.countdowntimer;

import javafx.util.Callback;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author lyning
 */
public class Countdown {

    private StateEnum state = StateEnum.NONE;
    private Thread thread;
    CountdownTimer countdownTimer;

    public Countdown(int second, Callback tick) {
        this.countdownTimer = new CountdownTimer(tick, second, TimeUnit.SECONDS);
    }

    public Future start() {
        this.state = StateEnum.RUNNING;
        Future future = this.countdownTimer.schedule();
        this.thread = new Thread(() -> {
            while (!future.isDone()) {
                // nothing
            }
            this.state = StateEnum.STOPPED;
            this.thread.interrupt();
        });
        this.thread.start();
        return future;
    }

    public boolean isRunning() {
        return state == StateEnum.RUNNING;
    }

    private enum StateEnum {
        NONE,
        RUNNING,
        STOPPED
    }
}
