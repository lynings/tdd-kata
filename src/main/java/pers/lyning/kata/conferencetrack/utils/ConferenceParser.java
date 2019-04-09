package pers.lyning.kata.conferencetrack.utils;

import pers.lyning.kata.conferencetrack.Talk;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author lyning
 */
public class ConferenceParser {

    public static List<Talk> parse(InputStream inputStream) throws IOException {
        String talkString = getStringFromInputStream(inputStream);
        return Arrays.asList(talkString.split("\\n\\n|\\n"))
                .stream()
                .map(talk -> talk.replace("\n", ""))
                .map(talk -> new Talk(talk, talk.indexOf("lightning") >= 0 ? 5 : Integer.valueOf(talk.split(" ")[talk.split(" ").length - 1].replace("min", ""))))
                .collect(toList());
    }

    private static String getStringFromInputStream(InputStream inputStream) throws IOException {
        InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");

        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
        }
        reader.close();
        inputStream.close();
        return sb.toString();
    }
}
