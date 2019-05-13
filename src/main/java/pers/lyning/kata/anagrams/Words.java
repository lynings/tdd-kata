package pers.lyning.kata.anagrams;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

/**
 * @author lyning
 */
public class Words {
    private final Set<String> words;

    private Words(Set<String> words) {
        this.words = words;
    }

    public static Words of(String... words) {
        return new Words(Sets.newHashSet(words));
    }

    public static Words of(List<String> words) {
        return new Words(Sets.newHashSet(words));
    }

    public int size() {
        return words.size();
    }

    public Set<String> get() {
        return this.words;
    }
}
