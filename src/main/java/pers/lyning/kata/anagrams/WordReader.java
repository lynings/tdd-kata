package pers.lyning.kata.anagrams;

import com.google.common.collect.Sets;
import pers.lyning.kata.utils.FileContentReader;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author lyning
 */
class WordReader {

    private final List<String> words;

    public WordReader(List<String> words) {
        this.words = words;
    }

    public static WordReader from(File file) throws IOException {
        String wordsString = FileContentReader.asString(file);
        List<String> words = readAsWord(wordsString);
        return new WordReader(words);
    }

    private static List<String> readAsWord(String wordsString) {
        return splitWord(wordsString)
                .flatMap(words -> Sets.newHashSet(words).stream())
                .filter(word -> !word.isEmpty())
                .collect(toList());
    }

    private static Stream<String[]> splitWord(String wordsString) {
        return Arrays.asList(wordsString.split("\\n\\n|\\n"))
                .stream()
                .map(s -> s.split(" "));
    }

    public Words asWords() {
        return Words.of(words);
    }
}
