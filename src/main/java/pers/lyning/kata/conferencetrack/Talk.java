package pers.lyning.kata.conferencetrack;

/**
 * @author lyning
 */
public class Talk {

    private String title;

    private Integer durationMinutes;

    public Talk(String title, Integer durationMinutes) {
        this.title = title;
        this.durationMinutes = durationMinutes;
    }

    public String getTitle() {
        return title;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }
}
