package pers.lyning.kata.anagrams;

import org.junit.Test;
import pers.lyning.kata.conferencetrack.ConferenceManagerTest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class AnagramsTest {

    /******************* arranged test start *****************/
    @Test
    public void arranged_kinship_pinkish_words() {
        Words words = Words.of("kinship", "pinkish");
        Anagrams anagrams = new Anagrams(words);
        List<Anagram> anagramList = anagrams.arranged();

        assertThat(anagramList).isNotEmpty();
        assertThat(anagramList.size()).isEqualTo(1);
        assertThat(anagramList.get(0).list().size()).isEqualTo(words.size());
        assertThat(anagramList.get(0).contains("kinship")).isTrue();
        assertThat(anagramList.get(0).contains("pinkish")).isTrue();
    }

    @Test
    public void arranged_10_word_list() {
        Words words = Words.of(
                "kinship", "pinkish",
                "abc", "acb", "bca", "bac", "cab", "cba",
                "lyning", "ningly"
        );
        Anagrams anagrams = new Anagrams(words);
        List<Anagram> anagramList = anagrams.arranged();

        assertThat(anagramList).isNotEmpty();
        assertThat(anagramList.size()).isEqualTo(3);
        assertThat(this.countWords(anagramList)).isEqualTo(words.size());
        for (Anagram anagram : anagramList) {
            for (String word : anagram.list()) {
                assertThat(words.contains(word)).isTrue();
            }
        }

    }

    @Test
    public void arranged_17_word_list() {
        Words words = Words.of(
                "kinship", "pinkish",
                "enlist", "inlets", "listen", "silent",
                "boaster", "boaters", "borates",
                "fresher", "refresh",
                "sinks", "skins",
                "knits", "stink",
                "rots", "sort"
        );
        Anagrams anagrams = new Anagrams(words);
        List<Anagram> anagramList = anagrams.arranged();

        assertThat(anagramList).isNotEmpty();
        assertThat(anagramList.size()).isEqualTo(7);
        assertThat(this.countWords(anagramList)).isEqualTo(words.size());
        for (Anagram anagram : anagramList) {
            for (String word : anagram.list()) {
                assertThat(words.contains(word)).isTrue();
            }
        }
    }

    @Test
    public void arranged_1633_word_list() throws IOException {
        File file = new File(ConferenceManagerTest.class.getResource("/anagrams/wordlist_1633.txt").getPath());
        Words words = Words.parse(file);
        Anagrams anagrams = new Anagrams(words);
        List<Anagram> anagramList = anagrams.arranged();
        assertThat(anagramList).isNotEmpty();
        assertThat(anagramList.size()).isEqualTo(23);
    }

    @Test
    public void arranged_338882_word_list() throws IOException {
        File file = new File(ConferenceManagerTest.class.getResource("/anagrams/wordlist_338882.txt").getPath());
        Words words = Words.parse(file);
        Anagrams anagrams = new Anagrams(words);
        List<Anagram> anagramList = anagrams.arranged();
        assertThat(anagramList).isNotEmpty();
        assertThat(anagramList.size()).isEqualTo(20683);
        assertThat(this.countWords(anagramList)).isEqualTo(48162);
    }

    private int countWords(List<Anagram> anagramList) {
        return anagramList.stream().map(a -> a.list().size()).reduce(Integer::sum).get();
    }
    /******************* arranged test end *****************/


    /******************* findLongestWords test start *****************/
    @Test
    public void should_return_longest_words() {
        Words words = Words.of(
                "kinship", "pinkish",
                "enlist", "inlets", "listen", "silent",
                "boaster", "boaters", "borates",
                "fresher", "refresh",
                "sinks", "skins",
                "knits", "stink",
                "rots", "sort",
                "anagrams"
        );
        Anagrams anagrams = new Anagrams(words);
        List<Anagram> anagramList = anagrams.arranged();

        Words longestWords = anagrams.findLongest(anagramList);
        assertThat(longestWords.size()).isEqualTo(1);
        assertThat(longestWords.list()).isEqualTo(Arrays.asList("anagrams"));
    }
    /******************* findLongestWords test end *****************/


    /******************* findMostWords test start *****************/
    @Test
    public void should_return_most_words() {
        Words words = Words.of(
                "kinship", "pinkish",
                "enlist", "inlets", "listen", "silent",
                "boaster", "boaters", "borates",
                "fresher", "refresh",
                "sinks", "skins",
                "knits", "stink",
                "rots", "sort",
                "abc", "acb", "bca", "bac", "cab", "cba"
        );
        Anagrams anagrams = new Anagrams(words);
        List<Anagram> anagramList = anagrams.arranged();

        Words mostWords = anagrams.findMost(anagramList);
        assertThat(mostWords.size()).isEqualTo(6);
        assertThat(mostWords.contains("abc")).isTrue();
        assertThat(mostWords.contains("acb")).isTrue();
        assertThat(mostWords.contains("bca")).isTrue();
        assertThat(mostWords.contains("bac")).isTrue();
        assertThat(mostWords.contains("cab")).isTrue();
        assertThat(mostWords.contains("cba")).isTrue();
    }
    /******************* findMostWords test end *****************/
}
