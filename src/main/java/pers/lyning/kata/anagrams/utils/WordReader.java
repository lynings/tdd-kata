package pers.lyning.kata.anagrams.utils;

import pers.lyning.kata.anagrams.Word;
import pers.lyning.kata.utils.FileContentReader;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

/**
 * @author lyning
 */
public class WordReader {

    private final Set<String> words;

    public WordReader(Set<String> words) {
        this.words = words;
    }

    public static WordReader from(File file) throws IOException {
        String wordsString = FileContentReader.asString(file);
        Set<String> words = readAsWord(wordsString);
        return new WordReader(words);
    }

    private static Set<String> readAsWord(String wordsString) {
        return splitWord(wordsString)
                .flatMap(Stream::of)
                .filter(word -> !word.isEmpty())
                .collect(toSet());
    }

    private static Stream<String[]> splitWord(String wordsString) {
        return Arrays.asList(wordsString.split("\\n\\n|\\n"))
                .stream()
                .map(s -> s.split(" "));
    }

    public Set<Word> asWords() {
        return words.stream().map(Word::new).collect(toSet());
    }
}
