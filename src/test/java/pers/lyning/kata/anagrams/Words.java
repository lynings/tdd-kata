package pers.lyning.kata.anagrams;

import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * @author lyning
 */
class Words {

    public static Set<Word> asSet(String... words) {
        return Arrays.asList(words)
                .stream()
                .map(Word::new)
                .collect(toSet());
    }
}