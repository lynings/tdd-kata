package pers.lyning.kata.countdowntimer;

import javafx.util.Callback;

import java.util.concurrent.Future;

/**
 * @author lyning
 */
public class Countdown {

    CountdownTimer countdownTimer;
    private volatile StateEnum state = StateEnum.NONE;
    private Future timerFuture;

    public Countdown(int second, Callback tick) {
        this.countdownTimer = new CountdownTimer(tick, second);
    }

    public Future start() {
        this.state = StateEnum.RUNNING;
        timerFuture = this.countdownTimer.schedule((out) -> {
            this.stop();
            return out;
        });
        return timerFuture;
    }

    public boolean isRunning() {
        return this.state == StateEnum.RUNNING;
    }

    private void stop() {
        this.state = StateEnum.STOPPED;
        this.timerFuture.cancel(true);
    }

    private enum StateEnum {
        NONE,
        RUNNING,
        STOPPED
    }
}
