package pers.lyning.kata.conferencetrack;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @author lyning
 */
public class ConferenceManager {

    public Conference planning(List<Talk> talks) {
        ConferencePlanner conferencePlanner = new ConferencePlanner();
        Conference conference = conferencePlanner.execute(talks);
        return conference;
    }

    public void display(Conference conference) {
        for (int index = 1; index <= conference.getTracks().size(); index++) {
            System.out.println("Track " + index + ":");
            Track track = conference.getTracks().get(index - 1);
            this.display(track.getMorning(), ConferenceConfig.MORNING_SESSION_START_HOURS);
            this.display(track.getAfternoon(), ConferenceConfig.AFTERNOON_SESSION_START_HOURS);
        }

    }

    private void display(Session session, int startHour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.add(Calendar.MINUTE, startHour * 60);
        SimpleDateFormat sdf = new SimpleDateFormat("h:mma");
        for (Talk talk : session.getTalks()) {
            System.out.println(sdf.format(calendar.getTime()) + " " + talk.getTitle());
            calendar.add(Calendar.MINUTE, talk.getDurationMinutes());
        }
    }
}
