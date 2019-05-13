package pers.lyning.kata.anagrams;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

/**
 * @author lyning
 */
class WordArranger {

    private final Set<Word> words;

    public WordArranger(Set<Word> words) {
        this.words = words;
    }

    public List<Set<Word>> arrange() {
        return this.groupBy(Word::asc)
                .stream()
                .collect(toList());
    }

    private Collection<Set<Word>> groupBy(Function<Word, String> sortFn) {
        return this.words.stream()
                .distinct()
                .collect(groupingBy(sortFn, toSet()))
                .values();
    }
}
