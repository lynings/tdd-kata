package pers.lyning.kata.countdowntimer2;

import java.time.Clock;
import java.time.Instant;

public class Tick {
    private static final int SECOND_TO_TICK = 1;
    private final Instant time;
    private final Clock clock;

    public Tick(Instant time, Clock clock) {
        this.clock = clock;
        this.time = time;
    }

    public Tick next() {
        return new Tick(time.plusSeconds(SECOND_TO_TICK), clock);
    }

    public boolean isNext() {
        return clock.instant().minusSeconds(SECOND_TO_TICK).compareTo(time) >= 0;
    }
}
