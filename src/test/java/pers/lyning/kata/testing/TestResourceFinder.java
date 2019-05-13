package pers.lyning.kata.testing;

import java.io.File;

/**
 * @author lyning
 */
public class TestResourceFinder {

    public static File getFile(String filePath) {
        return new File(TestResourceFinder.class.getResource(filePath).getPath());
    }
}
