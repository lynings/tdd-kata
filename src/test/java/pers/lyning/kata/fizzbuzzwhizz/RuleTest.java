package pers.lyning.kata.fizzbuzzwhizz;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RuleTest {

    private final List<GameRule> gameRules = Lists.list(
            new GameRule(3, "Fizz"),
            new GameRule(5, "Buzz"),
            new GameRule(7, "Whizz")
    );

    @Test
    public void should_return_1_when_mismatch_any_number() {
        assertThat(Rule.countOff(1, gameRules)).isEqualTo("1");
    }

    @Test
    public void should_return_fizz_when_just_a_multiple_of_the_first_number() {
        assertThat(Rule.countOff(3, gameRules)).isEqualTo("Fizz");
        assertThat(Rule.countOff(6, gameRules)).isEqualTo("Fizz");
    }

    @Test
    public void should_return_buzz_when_just_a_multiple_of_the_second_number() {
        assertThat(Rule.countOff(5, gameRules)).isEqualTo("Buzz");
        assertThat(Rule.countOff(10, gameRules)).isEqualTo("Buzz");
    }

    @Test
    public void should_return_whizz_when_just_a_multiple_of_the_third_number() {
        assertThat(Rule.countOff(7, gameRules)).isEqualTo("Whizz");
        assertThat(Rule.countOff(14, gameRules)).isEqualTo("Whizz");
    }

    @Test
    public void should_return_fizzbuzz_when_just_a_multiple_of_the_first_number_and_second_number() {
        assertThat(Rule.countOff(15, gameRules)).isEqualTo("FizzBuzz");
        assertThat(Rule.countOff(45, gameRules)).isEqualTo("FizzBuzz");
    }

    @Test
    public void should_return_fizzwhizz_when_just_a_multiple_of_the_first_number_and_third_number() {
        assertThat(Rule.countOff(21, gameRules)).isEqualTo("FizzWhizz");
        assertThat(Rule.countOff(42, gameRules)).isEqualTo("FizzWhizz");
    }

    @Test
    public void should_return_buzzwhizz_when_just_a_multiple_of_the_second_number_and_third_number() {
        assertThat(Rule.countOff(70, gameRules)).isEqualTo("BuzzWhizz");
    }

    @Test
    public void should_return_fizzbuzzwhizz_when_at_the_same_time_is_a_multiple_of_the_three_number() {
        List<GameRule> gameRules = Lists.list(
                new GameRule(2, "Fizz"),
                new GameRule(3, "Buzz"),
                new GameRule(4, "Whizz")
        );
        assertThat(Rule.countOff(48, gameRules)).isEqualTo("FizzBuzzWhizz");
        assertThat(Rule.countOff(96, gameRules)).isEqualTo("FizzBuzzWhizz");
    }

    @Test
    public void should_return_fizz_when_included_the_first_number() {
        assertThat(Rule.countOff(3, gameRules)).isEqualTo("Fizz");
        assertThat(Rule.countOff(13, gameRules)).isEqualTo("Fizz");
        assertThat(Rule.countOff(30, gameRules)).isEqualTo("Fizz");
        assertThat(Rule.countOff(31, gameRules)).isEqualTo("Fizz");
    }
}
