package pers.lyning.kata.conferencetrack;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pers.lyning.kata.conferencetrack.utils.TalkParser;
import pers.lyning.kata.testing.SystemOutputCapture;
import pers.lyning.kata.testing.TestResourceFinder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ConferenceManagerTest {

    @Rule
    public final SystemOutputCapture outputCapture = SystemOutputCapture.init();

    private List<Talk> talks = null;
    private ConferenceManager conferenceManager;
    private TalkParser talkParser = new TalkParser();

    @Before
    public void setUp() throws Exception {
        this.conferenceManager = new ConferenceManager();

        File file = TestResourceFinder.getFile("/conferencetrack/talk_list.txt");
        talks = talkParser.parse(file);
    }

    @Test
    public void check_morning_sessions_begin_at_9am_and_must_finish_before_12_noon_for_lunch() {
        Conference conference = this.conferenceManager.planning(talks);
        for (Track track : conference.getTracks()) {
            assertThat(track.getMorning().getRemainingMinutes()).isEqualTo(0);
            int morningDurationMinute = this.sumDurationMinutesOfTalks(track.getMorning().getTalks());
            assertThat(morningDurationMinute).isEqualTo(180);

            Talk lastTalk = getLastTalk(track.getMorning().getTalks());
            assertThat(lastTalk.getTitle().contains("Lunch"));
        }
    }

    @Test
    public void check_afternoon_sessions_begin_must_finish_in_time_for_the_networking_event() {
        Conference conference = this.conferenceManager.planning(talks);
        for (Track track : conference.getTracks()) {
            Talk lastTalk = getLastTalk(track.getMorning().getTalks());
            assertThat(lastTalk.getTitle().contains("NETWORKING EVENT"));
        }
    }

    @Test
    public void check_the_networking_event_can_start_no_earlier_than_4mp_and_no_later_than_5mp() {
        Conference conference = this.conferenceManager.planning(talks);
        for (Track track : conference.getTracks()) {
            Talk lastTalk = getLastTalk(track.getMorning().getTalks());
            assertThat(lastTalk.getTitle().contains("NETWORKING EVENT"));

            int morningDurationMinute = this.sumDurationMinutesOfTalks(track.getAfternoon().getTalks());
            assertThat(morningDurationMinute).isLessThanOrEqualTo(240);
            assertThat(morningDurationMinute).isGreaterThan(180);
            assertThat(track.getAfternoon().getRemainingMinutes()).isBetween(0, 59);

        }
    }

    @Test
    public void check_display_conference() {
        Conference conference = this.conferenceManager.planning(talks);
        this.conferenceManager.display(conference);
        for (Track track : conference.getTracks()) {
            List<Talk> talkList = new ArrayList<>();
            talkList.addAll(track.getMorning().getTalks());
            talkList.addAll(track.getAfternoon().getTalks());
            for (Talk talk : talkList) {
                assertThat(outputCapture.toString()).contains(talk.getTitle());
            }
        }
    }

    private int sumDurationMinutesOfTalks(List<Talk> talks) {
        return talks.stream().map(Talk::getDurationMinutes).reduce(Integer::sum).get();
    }

    private Talk getLastTalk(List<Talk> talks) {
        return talks.get(talks.size() - 1);
    }
}
