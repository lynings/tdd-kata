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
        while (!talks.isEmpty()) {
            Session morning = this.planningMorning(talks);
            Session afternoon = this.planningAfternoon(talks);
            conference.addSession(morning, afternoon);
        }
        return conference;
    }

    private List<Talk> defineTalksScope(List<Talk> talks, Integer durationMinutes) {
        return talks
                .stream()
                .filter(talk -> talk.getDurationMinutes() <= durationMinutes)
                .collect(toList());
    }

    private Session planningAfternoon(List<Talk> talks) {
        Session afternoon = this.planningBySession(talks, ConferenceConfig.AFTERNOON_SESSION_DURATION_MINUTES);
        afternoon.addTalk(new Talk("Networking Event", 0));
        return afternoon;
    }

    private Session planningBySession(List<Talk> talks, Integer sessionDurationMinutes) {
        Session session = new Session(sessionDurationMinutes);
        while (session.hasRemainingMinutes() && !talks.isEmpty()) {
            Optional<Talk> talkOptional = this.searchAnyTalk(talks, session.getRemainingMinutes());
            if (talkOptional.isPresent()) {
                Talk talk = talkOptional.get();
                session.addTalk(talk);
                talks.remove(talk);
            } else {
                talks.addAll(session.getTalks());
                session.clear();
            }
        }
        return session;
    }

    private Session planningMorning(List<Talk> talks) {
        Session morning = this.planningBySession(talks, ConferenceConfig.MORNING_SESSION_DURATION_MINUTES);
        morning.addTalk(new Talk("Lunch", 0));
        return morning;
    }

    private Optional<Talk> searchAnyTalk(List<Talk> talks, Integer durationMinutes) {
        // 确定接下来参与计算的 talk 的范围
        List<Talk> talkGroup = this.defineTalksScope(talks, durationMinutes);
        if (talkGroup.isEmpty()) {
            return Optional.empty();
        }
        // 随机获取符合要求的 talk，目的是寻找所有可能的结果
        int random = RandomUnit.random(0, talkGroup.size() - 1);
        return Optional.of(talkGroup.get(random));
    }
}
