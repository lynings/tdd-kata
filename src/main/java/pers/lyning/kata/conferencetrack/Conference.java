package pers.lyning.kata.conferencetrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyning
 */
public class Conference {

    private List<Track> tracks = new ArrayList<>();

    public Conference addSession(Session morning, Session afternoon) {
        tracks.add(new Track(morning, afternoon));
        return this;
    }

    public List<Track> getTracks() {
        return tracks;
    }
}
