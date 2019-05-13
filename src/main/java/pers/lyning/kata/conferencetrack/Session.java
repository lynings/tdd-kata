package pers.lyning.kata.conferencetrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyning
 */
public class Session {

    private final int REMAINING_MINUTES_CONSTANT;
    private final List<Talk> talks = new ArrayList<>();
    /**
     * session 剩余时间
     */
    private int remainingMinutes;

    public Session(int remainingMinutes) {
        this.remainingMinutes = remainingMinutes;
        this.REMAINING_MINUTES_CONSTANT = remainingMinutes;
    }

    public void addTalk(Talk talk) {
        this.talks.add(talk);
        this.remainingMinutes -= talk.getDurationMinutes();
    }

    public void clear() {
        this.getTalks().clear();
        this.remainingMinutes = this.REMAINING_MINUTES_CONSTANT;
    }

    public int getRemainingMinutes() {
        return this.remainingMinutes;
    }

    public List<Talk> getTalks() {
        return this.talks;
    }

    public boolean hasRemainingMinutes() {
        return this.getRemainingMinutes() > 0;
    }
}
