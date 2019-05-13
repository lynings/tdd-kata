package pers.lyning.kata.anagrams;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author lyning
 */
class Anagram {

    private final Words words;

    private Anagram(Words words) {
        this.words = words;
    }

    public static Anagram of(Words words) {
        return new Anagram(words);
    }

    public static Anagram of(String... words) {
        return new Anagram(Words.of(words));
    }

    public List<String> asList() {
        return Lists.newArrayList(words.get());
    }

    public Integer length() {
        return this.anyWord().length();
    }

    public Integer size() {
        return this.words.size();
    }

    private String anyWord() {
        return this.words.get().iterator().next();
    }
}