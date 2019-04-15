package pers.lyning.kata.anagrams;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

/**
 * @author lyning
 */
public class Anagram {

    private Set<String> words;

    private Anagram(Set<String> words) {
        this.words = words;
    }

    public static Anagram of(String... words) {
        return new Anagram(Sets.newHashSet(words));
    }

    public static Anagram of(List<String> words) {
        return new Anagram(Sets.newHashSet(words));
    }

    public boolean contains(String word) {
        return this.words.contains(word);
    }

    public List<String> list() {
        return Lists.newArrayList(words);
    }

    public boolean is(String word) {
        return this.isAnagram(word);
    }

    private boolean isAnagram(String word) {
        String sourceWord = this.words.iterator().next();
        return WordUtils.sort(sourceWord).equals(WordUtils.sort(word));
    }

    public Integer length() {
        return this.words.iterator().next().length();
    }

    public Integer size() {
        return this.words.size();
    }
}
