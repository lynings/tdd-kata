package pers.lyning.kata.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author lyning
 */
public class FileContentReader {

    public static String asString(File file) throws IOException {
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
        }
        reader.close();
        inputStream.close();
        return sb.toString();
    }
}
