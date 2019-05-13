package pers.lyning.kata.anagrams;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

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

    public boolean contains(String word) {
        return this.words.contains(word);
    }

    public int size() {
        return words.size();
    }

    public List<String> asList() {
        return Lists.newArrayList(this.words);
    }

    public String firstWord() {
        return this.words.iterator().next();
    }
}
