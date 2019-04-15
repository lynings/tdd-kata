package pers.lyning.kata.anagrams;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import pers.lyning.kata.utils.FileContentReader;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * @author lyning
 */
public class Words {
    private Set<String> words;

    private Words(Set<String> words) {
        this.words = words;
    }

    public static Words of(String... words) {
        return new Words(Sets.newHashSet(words));
    }

    public static Words of(List<String> words) {
        return new Words(Sets.newHashSet(words));
    }

    public static Words parse(File file) throws IOException {
        String wordsString = FileContentReader.getString(file);
        return new Words(Arrays.asList(wordsString.split("\\n\\n|\\n"))
                .stream()
                .map(s -> s.split(" "))
                .flatMap(words -> Lists.newArrayList(words).stream())
                .filter(word -> !Strings.isNullOrEmpty(word))
                .collect(toSet()));
    }

    public boolean contains(String word) {
        return this.words.contains(word);
    }

    public int size() {
        return words.size();
    }

    public List<String> list() {
        return Lists.newArrayList(this.words);
    }
}
