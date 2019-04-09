package pers.lyning.kata.testing;

import org.junit.rules.ExternalResource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author lyning
 */
public class SystemOutputCapture extends ExternalResource {
    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Override
    protected void before() throws Throwable {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Override
    protected void after() {
        System.setOut(sysOut);
    }

    public static SystemOutputCapture init() {
        return new SystemOutputCapture();
    }

    public String toString() {
        return outContent.toString();
    }
}
