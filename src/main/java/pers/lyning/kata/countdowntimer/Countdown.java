package pers.lyning.kata.countdowntimer;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * @author lyning
 */
public class Countdown {

    private volatile int remainingSecond;
    private final Consumer<String> tick;
    private ScheduledFuture<?> future;
    private StateEnum state = StateEnum.NONE;
    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    public Countdown(int second, Consumer<String> tick) {
        this.remainingSecond = second;
        this.tick = tick;
        this.scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
    }

    public Future start() {
        this.state = StateEnum.RUNNING;
        this.future = this.scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            this.tick.accept("");
            this.remainingSecond -= 1;
            if (this.remainingSecond == 0) {
                future.cancel(true);
                this.state = StateEnum.DESTROYED;
            }
        }, 0, 1, TimeUnit.SECONDS);
        return future;
    }

    public boolean isRunning() {
        return state == StateEnum.RUNNING;
    }

    public void destroy() {
        this.state = StateEnum.DESTROYED;
        this.future.cancel(true);
    }

    private enum StateEnum {
        NONE,
        RUNNING,
        DESTROYED
    }
}
