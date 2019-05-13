package pers.lyning.kata.anagrams.utils;

import pers.lyning.kata.anagrams.Word;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

/**
 * @author lyning
 */
class WordArranger {

    public static List<Set<Word>> arrange(Set<Word> words) {
        return groupBySort(words)
                .stream()
                .collect(toList());
    }

    private static Collection<Set<Word>> groupBySort(Set<Word> words) {
        return words.stream()
                .distinct()
                .collect(groupingBy(Word::asc, toSet()))
                .values();
    }
}
