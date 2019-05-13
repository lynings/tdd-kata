package pers.lyning.kata.countdowntimer2;

import java.time.Clock;
import java.time.Instant;

public class Tick {
    private static final int SECOND_TO_TICK = 1;
    private final Clock clock;
    private final Instant time;

    public Tick(Instant time, Clock clock) {
        this.clock = clock;
        this.time = time;
    }

    public boolean isNext() {
        return this.clock.instant()
                .minusSeconds(SECOND_TO_TICK)
                .compareTo(this.time) >= 0;
    }

    public Tick next() {
        return new Tick(this.time.plusSeconds(SECOND_TO_TICK), this.clock);
    }
}
