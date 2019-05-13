package pers.lyning.kata.anagrams;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * @author lyning
 */
public class WordArranger {

    public static List<Words> arrange(Words words) {
        return groupBySort(words)
                .stream()
                .map(Words::of)
                .collect(toList());
    }

    private static Collection<List<String>> groupBySort(Words words) {
        return words.asList()
                .stream()
                .collect(groupingBy(WordUtils::sort, toList()))
                .values();
    }
}
