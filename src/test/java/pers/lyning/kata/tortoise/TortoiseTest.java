package pers.lyning.kata.tortoise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class TortoiseTest {

    @Test
    public void should_return_null_when_v1_is_equals_v2() {
        assertThat(Tortoise.race(1, 1, 1)).isEqualTo(new int[]{-1, -1, -1});
    }

    @Test
    public void race() {
        assertThat(Tortoise.race(80, 100, 40)).isEqualTo(new int[]{2, 0, 0});
        assertThat(Tortoise.race(720, 850, 70)).isEqualTo(new int[]{0, 32, 18});
        assertThat(Tortoise.race(80, 91, 37)).isEqualTo(new int[]{3, 21, 49});
    }
}
