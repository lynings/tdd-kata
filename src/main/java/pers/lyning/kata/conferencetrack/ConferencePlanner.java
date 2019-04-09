package pers.lyning.kata.conferencetrack;

import pers.lyning.kata.conferencetrack.utils.RandomUnit;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * @author lyning
 */
public class ConferencePlanner {

    public Conference execute(List<Talk> talks) {
        Conference conference = new Conference();
        while (talks.size() != 0) {
            Session morning = planningMorning(talks);
            Session afternoon = planningAfternoon(talks);
            conference.addSession(morning, afternoon);
        }
        return conference;
    }

    private Session planningAfternoon(List<Talk> talks) {
        Session afternoon = this.planningBySession(talks, ConferenceConfig.AFTERNOON_SESSION_DURATION_MINUTES);
        afternoon.addTalk(new Talk("Networking Event", 0));
        return afternoon;
    }

    private Session planningMorning(List<Talk> talks) {
        Session morning = planningBySession(talks, ConferenceConfig.MORNING_SESSION_DURATION_MINUTES);
        morning.addTalk(new Talk("Lunch", 0));
        return morning;
    }

    private Session planningBySession(List<Talk> talks, Integer sessionDurationMinutes) {
        Session session = new Session(sessionDurationMinutes);
        while (session.getRemainingMinutes() != 0 && talks.size() > 0) {
            Optional<Talk> talkOptional = this.searchAny(talks, session.getRemainingMinutes());
            if (!talkOptional.isPresent()) {
                talks.addAll(session.getTalks());
                session = new Session(sessionDurationMinutes);
            } else {
                Talk talk = talkOptional.get();
                session.addTalk(talk);
                talks.remove(talk);
            }
        }
        return session;
    }

    private Optional<Talk> searchAny(List<Talk> talks, Integer durationMinutes) {
        // 确定接下来参与计算的 talk 的范围
        List<Talk> talkList = defineNeighborhood(talks, durationMinutes);
        if (talkList.isEmpty()) {
            return Optional.empty();
        }
        // 随机获取符合要求的 talk
        int random = RandomUnit.random(0, talkList.size() - 1);
        return Optional.of(talkList.get(random));
    }

    private List<Talk> defineNeighborhood(List<Talk> talks, Integer durationMinutes) {
        return talks
                .stream()
                .filter(talk -> talk.getDurationMinutes() <= durationMinutes)
                .collect(toList());
    }
}
