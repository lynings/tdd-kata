package pers.lyning.kata.conferencetrack.utils;

import pers.lyning.kata.conferencetrack.ConferenceConfig;
import pers.lyning.kata.conferencetrack.Talk;
import pers.lyning.kata.utils.FileContentReader;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author lyning
 */
public class TalkParser {

    public List<Talk> parse(File file) throws IOException {
        String talkString = FileContentReader.asString(file);
        return Arrays.asList(talkString.split("\\n\\n|\\n"))
                .stream()
                .map(talk -> new Talk(talk, getMinutes(talk)))
                .collect(toList());
    }

    private int getMinutes(String talk) {
        if (isLightning(talk)) {
            return ConferenceConfig.LIGHTNING_DURATION_MINUTES;
        }

        String[] talkArr = talk.split(" ");
        String minutes = talkArr[talkArr.length - 1].replace("min", "");
        return Integer.valueOf(minutes);
    }

    private boolean isLightning(String talk) {
        return talk.indexOf("lightning") >= 0;
    }
}
