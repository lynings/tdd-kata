package pers.lyning.kata.countdowntimer2;

import static org.junit.Assert.assertEquals;

public class MockRunnable implements Runnable {
    private int runCount;

    @Override
    public void run() {
        runCount++;
    }

    public void verifyRunWithCount(int expected) {
        assertEquals(expected, runCount);
    }
}
