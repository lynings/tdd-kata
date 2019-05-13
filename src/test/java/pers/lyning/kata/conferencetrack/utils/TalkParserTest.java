package pers.lyning.kata.conferencetrack.utils;

import org.junit.Test;
import pers.lyning.kata.conferencetrack.Talk;
import pers.lyning.kata.testing.TestResourceFinder;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TalkParserTest {

    private TalkParser talkParser = new TalkParser();

    @Test
    public void parse() throws IOException {
        File file = TestResourceFinder.getFile("/conferencetrack/talk_list.txt");
        List<Talk> talks = talkParser.parse(file);
        assertThat(talks).isNotEmpty();
        assertThat(talks.size()).isEqualTo(19);
    }
}