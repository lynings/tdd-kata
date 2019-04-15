package pers.lyning.kata.anagrams;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

/**
 * @author lyning
 */
public class WordUtils {

    public static String sort(String word) {
        return Arrays.asList(word.split(""))
                .stream()
                .sorted()
                .collect(joining());
    }
}
