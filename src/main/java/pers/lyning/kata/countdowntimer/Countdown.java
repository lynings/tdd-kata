package pers.lyning.kata.countdowntimer;

import java.util.concurrent.Future;

/**
 * @author lyning
 */
public class Countdown {

    private final Runnable stopCallback;
    CountdownTimer countdownTimer;
    private Future timerFuture;
    private StateEnum state = StateEnum.NONE;

    public Countdown(int second, Runnable tick) {
        this.countdownTimer = new CountdownTimer(tick, second);
        this.stopCallback = () -> this.stop();
    }

    private enum StateEnum {
        NONE,
        RUNNING,
        STOPPED
    }

    public long getRemainingTime() {
        return this.countdownTimer.remainingTime();
    }

    public boolean isRunning() {
        return this.state == StateEnum.RUNNING;
    }

    public Future start() {
        this.state = StateEnum.RUNNING;
        this.timerFuture = this.countdownTimer.schedule(this.stopCallback);
        return this.timerFuture;
    }

    private void stop() {
        this.state = StateEnum.STOPPED;
        this.timerFuture.cancel(true);
    }
}
