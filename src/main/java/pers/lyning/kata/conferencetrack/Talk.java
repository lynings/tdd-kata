package pers.lyning.kata.conferencetrack;

/**
 * @author lyning
 */
public class Talk {

    private final Integer durationMinutes;
    private final String title;

    public Talk(String title, Integer durationMinutes) {
        this.title = title;
        this.durationMinutes = durationMinutes;
    }

    public Integer getDurationMinutes() {
        return this.durationMinutes;
    }

    public String getTitle() {
        return this.title;
    }
}
