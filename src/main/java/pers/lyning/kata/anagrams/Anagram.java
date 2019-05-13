package pers.lyning.kata.anagrams;

import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * @author lyning
 */
class Anagram {

    private final Set<Word> words;

    private Anagram(Set<Word> words) {
        this.words = words;
    }

    public Integer lengthOfWord() {
        return this.anyWord()
                .length();
    }

    public static Anagram of(Set<Word> words) {
        return new Anagram(words);
    }

    public static Anagram of(String... words) {
        Set<Word> wordSet = Arrays.asList(words)
                .stream()
                .map(Word::new)
                .collect(toSet());
        return new Anagram(wordSet);
    }

    public Integer size() {
        return this.words.size();
    }

    public Set<Word> words() {
        return this.words;
    }

    private String anyWord() {
        return this.words.iterator()
                .next()
                .value();
    }
}