package pers.lyning.kata.fizzbuzzwhizz3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class WordMatcherTest {

    private SpecialNumber first = new SpecialNumber(3, "Fizz");
    private SpecialNumber second = new SpecialNumber(5, "Buzz");
    private SpecialNumber third = new SpecialNumber(7, "Whizz");
    private WordMatcher wordMatcher = new WordMatcher(first, second, third);

    @Test
    public void should_return_Fizz_when_number_is_divisible_by_3() {
        List<Integer> numbers = Arrays.asList(3, 6, 9, 99);
        for (Integer num : numbers) {
            String word = wordMatcher.match(new Number(num));
            assertThat(word).isEqualTo("Fizz");
        }
    }

    @Test
    public void should_return_Buzz_when_number_is_divisible_by_5() {
        List<Integer> numbers = Arrays.asList(5, 10, 20, 100);
        for (Integer num : numbers) {
            String word = wordMatcher.match(new Number(num));
            assertThat(word).isEqualTo("Buzz");
        }
    }

    @Test
    public void should_return_Whizz_when_number_is_divisible_by_7() {
        List<Integer> numbers = Arrays.asList(7, 14, 28, 49);
        for (Integer num : numbers) {
            String word = wordMatcher.match(new Number(num));
            assertThat(word).isEqualTo("Whizz");
        }
    }

    @Test
    public void should_return_FizzBuzz_when_number_is_divisible_by_3_and_5() {
        List<Integer> numbers = Arrays.asList(15, 45, 75);
        for (Integer num : numbers) {
            String word = wordMatcher.match(new Number(num));
            assertThat(word).isEqualTo("FizzBuzz");
        }
    }

    @Test
    public void should_return_FizzWhizz_when_number_is_divisible_by_3_and_7() {
        List<Integer> numbers = Arrays.asList(21);
        for (Integer num : numbers) {
            String word = wordMatcher.match(new Number(num));
            assertThat(word).isEqualTo("FizzWhizz");
        }
    }

    @Test
    public void should_return_FizzBuzzWhizz_when_number_is_divisible_by_3_and_5_and_7() {
        List<Integer> numbers = Arrays.asList(105);
        for (Integer num : numbers) {
            String word = wordMatcher.match(new Number(num));
            assertThat(word).isEqualTo("FizzBuzzWhizz");
        }
    }

    @Test
    public void should_return_BuzzWhizz_when_number_is_divisible_by_5_and_7() {
        List<Integer> numbers = Arrays.asList(175);
        for (Integer num : numbers) {
            String word = wordMatcher.match(new Number(num));
            assertThat(word).isEqualTo("BuzzWhizz");
        }
    }

    @Test
    public void should_return_Fizz_when_number_is_contains_first_special_number() {
        List<Integer> numbers = Arrays.asList(3, 13, 31, 32, 33, 34, 35, 63);
        for (Integer num : numbers) {
            String word = wordMatcher.match(new Number(num));
            assertThat(word).isEqualTo("Fizz");
        }
    }
}
