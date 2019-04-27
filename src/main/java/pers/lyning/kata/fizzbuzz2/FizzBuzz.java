package pers.lyning.kata.fizzbuzz2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
                .filter(Optional::isPresent)
                .map(Optional::get)
                .reduce(FizzBuzz::mergeWord)
                .orElse(number.toString());
    }

    private static String mergeWord(String w1, String w2) {
        return w1.concat(w2);
    }
}
