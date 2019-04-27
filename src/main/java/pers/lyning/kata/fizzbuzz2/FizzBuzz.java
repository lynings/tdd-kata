package pers.lyning.kata.fizzbuzz2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author lyning
 */
public class FizzBuzz {
    private static final List<Word> WORDS = Arrays.asList(
            Word.fizz(),
            Word.buzz()
    );

    public static String say(Integer number) {
        return WORDS.stream()
                .map(word -> word.match(number))
                .filter(FizzBuzz::isNotEmpty)
                .reduce(FizzBuzz::mergeWord)
                .orElse(number.toString());
    }

    private static boolean isNotEmpty(String word) {
        return !Objects.isNull(word);
    }

    private static String mergeWord(String w1, String w2) {
        return w1.concat(w2);
    }
}
