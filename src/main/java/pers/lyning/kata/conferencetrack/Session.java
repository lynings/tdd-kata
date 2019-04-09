package pers.lyning.kata.conferencetrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyning
 */
public class Session {
    /**
     * session 剩余时间
     */
    private int remainingMinutes;

    private List<Talk> talks = new ArrayList<>();

    public Session(int remainingMinutes) {
        this.remainingMinutes = remainingMinutes;
    }

    public void addTalk(Talk talk) {
        this.talks.add(talk);
        this.remainingMinutes -= talk.getDurationMinutes();
    }

    public List<Talk> getTalks() {
        return talks;
    }

    public int getRemainingMinutes() {
        return remainingMinutes;
    }
}
