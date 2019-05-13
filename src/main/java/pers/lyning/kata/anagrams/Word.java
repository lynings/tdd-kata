package pers.lyning.kata.anagrams;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

/**
 * @author lyning
 */
public class Word {

    private final String value;

    public Word(String value) {
        this.value = value;
    }

    public String asc() {
        return Arrays.asList(this.value.split(""))
                .stream()
                .sorted()
                .collect(joining());
    }

    public String value() {
        return this.value;
    }
}
