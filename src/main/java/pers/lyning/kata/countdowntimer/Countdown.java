package pers.lyning.kata.countdowntimer;

import javafx.util.Callback;

import java.util.concurrent.Future;

/**
 * @author lyning
 */
public class Countdown {

    CountdownTimer countdownTimer;
    private StateEnum state = StateEnum.NONE;

    public Countdown(int second, Callback tick) {
        this.countdownTimer = new CountdownTimer(tick, second);
    }

    public Future start() {
        this.state = StateEnum.RUNNING;
        Future future = this.countdownTimer.schedule((out) -> {
            this.stop();
            return out;
        });
        return future;
    }

    private void stop() {
        this.state = StateEnum.STOPPED;

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
