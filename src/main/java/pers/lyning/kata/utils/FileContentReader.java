package pers.lyning.kata.utils;

import java.io.*;

/**
 * @author lyning
 */
public class FileContentReader {

    public static String asString(File file) throws IOException {
        InputStream inputStream = new FileInputStream(file);
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
