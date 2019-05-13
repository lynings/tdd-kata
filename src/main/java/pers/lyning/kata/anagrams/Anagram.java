package pers.lyning.kata.anagrams;

import java.util.List;

/**
 * @author lyning
 */
public class Anagram {

    private Words words;

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
        return words.asList();
    }

    public boolean is(String word) {
        String sourceWord = this.words.firstWord();
        return WordUtils.sort(sourceWord)
                .equals(WordUtils.sort(word));
    }

    public Integer length() {
        return this.words.firstWord().length();
    }

    public Integer size() {
        return this.words.size();
    }
}