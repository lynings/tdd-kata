package pers.lyning.kata.anagrams;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

/**
 * @author lyning
 */
public class Word {

    private String value;

    public Word(String value) {
        this.value = value;
    }

    public String asc() {
        return Arrays.asList(toStringArray())
                .stream()
                .sorted()
                .collect(joining());
    }

    private String[] toStringArray() {
        return value.split("");
    }

    public String value() {
        return value;
    }
}
