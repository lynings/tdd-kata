package pers.lyning.kata.fizzbuzzwhizz;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentTest {

    private final List<GameRule> gameRules = Lists.list(
            new GameRule(3, "Fizz"),
            new GameRule(5, "Buzz"),
            new GameRule(7, "Whizz")
    );

    @Test
    public void should_return_1_when_mismatch_any_random_number() {
        assertThat(Student.countOff(1, gameRules)).isEqualTo("1");
    }

    @Test
    public void should_return_fizz_when_just_a_multiple_of_the_first_random() {
        assertThat(Student.countOff(3, gameRules)).isEqualTo("Fizz");
        assertThat(Student.countOff(6, gameRules)).isEqualTo("Fizz");
    }

    @Test
    public void should_return_buzz_when_just_a_multiple_of_the_second_random() {
        assertThat(Student.countOff(5, gameRules)).isEqualTo("Buzz");
        assertThat(Student.countOff(10, gameRules)).isEqualTo("Buzz");
    }

    @Test
    public void should_return_whizz_when_just_a_multiple_of_the_third_random() {
        assertThat(Student.countOff(7, gameRules)).isEqualTo("Whizz");
        assertThat(Student.countOff(14, gameRules)).isEqualTo("Whizz");
    }
}
