package pers.lyning.kata.anagrams;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author lyning
 */
public class Anagrams {
    private final WordArranger wordArranger;

    public Anagrams(Set<Word> words) {
        this.wordArranger = new WordArranger(words);
    }

    public List<Anagram> arrange() {
        List<Set<Word>> wordsGroup = this.wordArranger.arrange();
        return this.filterAnagrams(wordsGroup)
                .map(Anagram::of)
                .collect(toList());
    }

    public Anagram longest(List<Anagram> anagrams) {
        return anagrams.stream()
                .max(Comparator.comparing(Anagram::lengthOfWord))
                .get();
    }

    public Anagram most(List<Anagram> anagrams) {
        return anagrams.stream()
                .max(Comparator.comparing(Anagram::size))
                .get();
    }

    private Stream<Set<Word>> filterAnagrams(List<Set<Word>> wordsGroup) {
        return wordsGroup.stream()
                .filter(words -> words.size() > 1);
    }
}
