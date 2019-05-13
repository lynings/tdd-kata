package pers.lyning.kata.conferencetrack;

/**
 * @author lyning
 */
public class Track {

    private final Session afternoon;
    private final Session morning;

    public Track(Session morning, Session afternoon) {
        this.morning = morning;
        this.afternoon = afternoon;
    }

    public Session getAfternoon() {
        return this.afternoon;
    }

    public Session getMorning() {
        return this.morning;
    }
}
