package pers.lyning.kata.countdowntimer2;

import java.time.Clock;

import static java.time.Clock.systemUTC;

public class Timer {
    private final Clock clock;
    private final int countDownSecond;

    public Timer(int countDownSecond, Clock clock) {
        this.countDownSecond = countDownSecond;
        this.clock = clock;
    }

    public Timer(int countDownSecond) {
        this(countDownSecond, systemUTC());
    }

    public void start(Runnable runnable) {
        Tick tick = new Tick(clock.instant(), clock);
        int currentCountDown = countDownSecond;
        while (currentCountDown > 0) {
            if (tick.isNext()) {
                runnable.run();
                currentCountDown--;
                tick = tick.next();
            }
        }
    }

}
