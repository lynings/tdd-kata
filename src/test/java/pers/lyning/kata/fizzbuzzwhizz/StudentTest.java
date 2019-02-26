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

    @Test
    public void should_return_fizzbuzz_when_just_a_multiple_of_the_first_random_and_second_random() {
        assertThat(Student.countOff(15, gameRules)).isEqualTo("FizzBuzz");
        assertThat(Student.countOff(45, gameRules)).isEqualTo("FizzBuzz");
    }

    @Test
    public void should_return_fizzwhizz_when_just_a_multiple_of_the_first_random_and_third_random() {
        assertThat(Student.countOff(21, gameRules)).isEqualTo("FizzWhizz");
        assertThat(Student.countOff(42, gameRules)).isEqualTo("FizzWhizz");
    }

    @Test
    public void should_return_buzzwhizz_when_just_a_multiple_of_the_second_random_and_third_random() {
        assertThat(Student.countOff(70, gameRules)).isEqualTo("BuzzWhizz");
    }

    @Test
    public void should_return_fizzbuzzwhizz_when_just_a_multiple_of_the_three_random() {
        List<GameRule> gameRules = Lists.list(
                new GameRule(2, "Fizz"),
                new GameRule(3, "Buzz"),
                new GameRule(4, "Whizz")
        );
        assertThat(Student.countOff(48, gameRules)).isEqualTo("FizzBuzzWhizz");
        assertThat(Student.countOff(96, gameRules)).isEqualTo("FizzBuzzWhizz");
    }

    @Test
    public void should_return_fizz_when_included_the_first_random() {
        assertThat(Student.countOff(3, gameRules)).isEqualTo("Fizz");
        assertThat(Student.countOff(13, gameRules)).isEqualTo("Fizz");
        assertThat(Student.countOff(30, gameRules)).isEqualTo("Fizz");
        assertThat(Student.countOff(31, gameRules)).isEqualTo("Fizz");
    }
}
