package pers.lyning.kata.conferencetrack;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @author lyning
 */
public class ConferenceManager {

    public void display(Conference conference) {
        for (int index = 0, len = conference.getTracks().size(); index < len; index++) {
            System.out.println("Track " + (index + 1) + ":");
            Track track = conference.getTracks().get(index);
            this.display(track.getMorning(), ConferenceConfig.MORNING_SESSION_START_HOURS);
            this.display(track.getAfternoon(), ConferenceConfig.AFTERNOON_SESSION_START_HOURS);
        }

    }

    public Conference planning(List<Talk> talks) {
        ConferencePlanner conferencePlanner = new ConferencePlanner();
        Conference conference = conferencePlanner.execute(talks);
        return conference;
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
