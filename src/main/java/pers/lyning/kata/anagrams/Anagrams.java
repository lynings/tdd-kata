package pers.lyning.kata.anagrams;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * @author lyning
 */
public class Anagrams {
    private Words words;

    public Anagrams(Words words) {
        this.words = words;
    }

    public List<Anagram> arranged() {
        return this.group(this.words.list())
                .stream()
                .map(Anagram::of)
                .collect(toList());
    }

    public Words findLongestWords(List<Anagram> anagramList) {
        String[] wordArr = anagramList
                .stream()
                .max(Comparator.comparing(Anagram::length))
                .get()
                .list()
                .stream()
                .toArray(String[]::new);
        return Words.of(wordArr);
    }

    public Words findMostWords(List<Anagram> anagramList) {
        String[] wordArr = anagramList
                .stream()
                .max(Comparator.comparing(Anagram::size))
                .get()
                .list()
                .stream()
                .toArray(String[]::new);
        return Words.of(wordArr);
    }

    private List<List<String>> group(List<String> words) {
        return words
                .stream()
                .collect(groupingBy(WordUtils::sort, toList()))
                .values()
                .stream()
                .collect(toList());
    }
}
