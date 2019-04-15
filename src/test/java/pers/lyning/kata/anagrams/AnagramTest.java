package pers.lyning.kata.anagrams;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnagramTest {

    @Test
    public void should_return_true_when_is_anagram() {
        Anagram anagram = Anagram.of("kinship");
        assertThat(anagram.is("pinkish")).isTrue();
        assertThat(anagram.is("shpinki")).isTrue();
    }


    @Test
    public void should_return_false_when_is_not_anagram() {
        Anagram anagram = Anagram.of("kinship");
        assertThat(anagram.is("apinkish")).isFalse();
        assertThat(anagram.is("ashpinki")).isFalse();
    }

    @Test
    public void should_return_true_when_contains_word() {
        Anagram anagram = Anagram.of("kinship");
        assertThat(anagram.is("kinship"));
    }

    @Test
    public void should_return_false_when_contains_word() {
        Anagram anagram = Anagram.of("kinship");
        assertThat(anagram.is("pinkish"));
    }
}