package pers.lyning.kata.conferencetrack;

/**
 * @author lyning
 */
public class Track {

    private Session morning;

    private Session afternoon;

    public Track(Session morning, Session afternoon) {
        this.morning = morning;
        this.afternoon = afternoon;
    }

    public Session getMorning() {
        return morning;
    }

    public Session getAfternoon() {
        return afternoon;
    }
}
