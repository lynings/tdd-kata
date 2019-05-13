package pers.lyning.kata.fizzbuzz;

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
        return matchWord(number).orElse(number.toString());
    }

    private static String concatWord(String w1, String w2) {
        return w1.concat(w2);
    }

    private static Optional<String> matchWord(Integer number) {
        return WORDS.stream()
                .filter(word -> word.match(number))
                .map(Word::toString)
                .reduce(FizzBuzz::concatWord);
    }
}
