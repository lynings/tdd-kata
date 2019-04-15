package pers.lyning.kata.anagrams;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * @author lyning
 */
public class Anagrams {
    private Words words;

    public Anagrams(Words words) {
        this.words = words;
    }

    public List<Anagram> arranged() {
        List<Anagram> anagramList = new ArrayList<>();
        List<String> words = this.words.list();
        Map<Integer, List<String>> lenToWordsMap = words
                .stream()
                .collect(groupingByConcurrent(String::length, toList()));
        for (Map.Entry<Integer, List<String>> entry : lenToWordsMap.entrySet()) {
            Map<String, List<String>> map = entry
                    .getValue()
                    .stream()
                    .collect(groupingBy(word -> distinct(word), TreeMap::new, mapping(c -> c, toList())));
            for (List<String> wordList : map.values()) {
                while (wordList.size() != 0) {
                    Iterator<String> wordsIterator = wordList.iterator();
                    Anagram anagram = Anagram.of(wordsIterator.next());
                    wordsIterator.remove();
                    for (; wordsIterator.hasNext(); ) {
                        String word = wordsIterator.next();
                        if (anagram.is(word)) {
                            anagram.add(word);
                            wordsIterator.remove();
                        }
                    }
                    anagramList.add(anagram);
                }
            }
        }
        return anagramList;
    }

    private String distinct(String word) {
        return Arrays.asList(word.split("")).stream().distinct().sorted().collect(joining());
    }
}
