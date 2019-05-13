package pers.lyning.kata.testing;

import org.junit.rules.ExternalResource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author lyning
 */
public class SystemOutputCapture extends ExternalResource {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream sysOut;

    private SystemOutputCapture() {
    }

    public static SystemOutputCapture init() {
        return new SystemOutputCapture();
    }

    @Override
    public String toString() {
        return this.outContent.toString().trim();
    }

    @Override
    protected void before() throws Throwable {
        this.sysOut = System.out;
        System.setOut(new PrintStream(this.outContent));
    }

    @Override
    protected void after() {
        System.setOut(this.sysOut);
        System.out.println(this.outContent.toString());
    }
}
