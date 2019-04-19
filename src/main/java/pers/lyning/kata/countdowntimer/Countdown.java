package pers.lyning.kata.countdowntimer;

import java.util.concurrent.Future;

/**
 * @author lyning
 */
public class Countdown {

    CountdownTimer countdownTimer;
    private Future timerFuture;
    private StateEnum state = StateEnum.NONE;
    private final Runnable stopCallback;

    public Countdown(int second, Runnable tick) {
        this.countdownTimer = new CountdownTimer(tick, second);
        this.stopCallback = () -> this.stop();
    }

    public Future start() {
        this.state = StateEnum.RUNNING;
        this.timerFuture = this.countdownTimer.schedule(stopCallback);
        return this.timerFuture;
    }

    public boolean isRunning() {
        return this.state == StateEnum.RUNNING;
    }

    public long getRemainingTime() {
        return this.countdownTimer.remainingTime();
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
