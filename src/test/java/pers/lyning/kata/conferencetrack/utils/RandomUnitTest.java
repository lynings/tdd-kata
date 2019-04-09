package pers.lyning.kata.conferencetrack.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUnitTest {

    @Test
    public void should_random_between_0_10() {
        for (int i = 0; i < 1000; i++) {
            assertThat(RandomUnit.random(0, 10)).isBetween(0, 10);
        }
    }
}