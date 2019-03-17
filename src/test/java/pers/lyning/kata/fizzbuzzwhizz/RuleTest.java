package pers.lyning.kata.fizzbuzzwhizz;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RuleTest {

    final Rule rule = new Rule(Arrays.asList(3, 5, 7));

    @Test
    public void should_return_1_when_mismatch_any_number() {
        assertThat(rule.match(1)).isEqualTo("1");
    }

    @Test
    public void should_return_fizz_when_just_a_multiple_of_the_first_number() {
        assertThat(rule.match(3)).isEqualTo("Fizz");
        assertThat(rule.match(6)).isEqualTo("Fizz");
    }

    @Test
    public void should_return_buzz_when_just_a_multiple_of_the_second_number() {
        assertThat(rule.match(5)).isEqualTo("Buzz");
        assertThat(rule.match(10)).isEqualTo("Buzz");
    }

    @Test
    public void should_return_whizz_when_just_a_multiple_of_the_third_number() {
        assertThat(rule.match(7)).isEqualTo("Whizz");
        assertThat(rule.match(14)).isEqualTo("Whizz");
    }

    @Test
    public void should_return_fizzbuzz_when_just_a_multiple_of_the_first_number_and_second_number() {
        assertThat(rule.match(15)).isEqualTo("FizzBuzz");
        assertThat(rule.match(45)).isEqualTo("FizzBuzz");
    }

    @Test
    public void should_return_fizzwhizz_when_just_a_multiple_of_the_first_number_and_third_number() {
        assertThat(rule.match(21)).isEqualTo("FizzWhizz");
        assertThat(rule.match(42)).isEqualTo("FizzWhizz");
    }

    @Test
    public void should_return_buzzwhizz_when_just_a_multiple_of_the_second_number_and_third_number() {
        assertThat(rule.match(70)).isEqualTo("BuzzWhizz");
    }

    @Test
    public void should_return_fizzbuzzwhizz_when_at_the_same_time_is_a_multiple_of_the_three_number() {
        Rule rule = new Rule(Arrays.asList(2, 3, 4));
        assertThat(rule.match(48)).isEqualTo("FizzBuzzWhizz");
        assertThat(rule.match(96)).isEqualTo("FizzBuzzWhizz");
    }

    @Test
    public void should_return_fizz_when_included_the_first_number() {
        assertThat(rule.match(3)).isEqualTo("Fizz");
        assertThat(rule.match(13)).isEqualTo("Fizz");
        assertThat(rule.match(30)).isEqualTo("Fizz");
        assertThat(rule.match(31)).isEqualTo("Fizz");
    }
}