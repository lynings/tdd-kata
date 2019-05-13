package pers.lyning.kata.anagrams;

import org.junit.Test;
import pers.lyning.kata.conferencetrack.ConferenceManagerTest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class AnagramsTest {

    /******************* arrange test start *****************/
    @Test
    public void arrange_kinship_pinkish_words() {
        // given
        Words words = Words.of("kinship", "pinkish");
        Anagrams anagrams = new Anagrams(words);

        // when
        List<Anagram> anagramList = anagrams.arrange();

        // then
        assertAnagramsEquals(anagramList, Arrays.asList(Anagram.of(words)));
    }

    @Test
    public void arrange_10_word_list() {
        // given
        Words words = Words.of(
                "kinship", "pinkish",
                "abc", "acb", "bca", "bac", "cab", "cba",
                "lyning", "ningly"
        );
        Anagrams anagrams = new Anagrams(words);

        // when
        List<Anagram> anagramList = anagrams.arrange();

        // then
        List<Anagram> givenResults = Arrays.asList(
                Anagram.of("kinship", "pinkish"),
                Anagram.of("abc", "acb", "bca", "bac", "cab", "cba"),
                Anagram.of("lyning", "ningly")
        );
        assertAnagramsEquals(anagramList, givenResults);
    }

    @Test
    public void arrange_17_word_list() {
        // given
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

        // when
        List<Anagram> anagramList = anagrams.arrange();

        // then
        List<Anagram> givenResults = Arrays.asList(
                Anagram.of("kinship", "pinkish"),
                Anagram.of("enlist", "inlets", "listen", "silent"),
                Anagram.of("boaster", "boaters", "borates"),
                Anagram.of("fresher", "refresh"),
                Anagram.of("sinks", "skins"),
                Anagram.of("knits", "stink"),
                Anagram.of("rots", "sort")
        );
        assertAnagramsEquals(anagramList, givenResults);
    }

    @Test
    public void arrange_1633_word_list() throws IOException {
        // given
        File file = getFile("/anagrams/wordlist_1633.txt");
        Words words = WordReader.from(file).asWords();
        Anagrams anagrams = new Anagrams(words);

        // when
        List<Anagram> anagramList = anagrams.arrange();

        // then
        assertThat(anagramList).isNotEmpty();
        assertThat(anagramList.size()).isEqualTo(23);
    }

    @Test
    public void arrange_338882_word_list() throws IOException {
        // given
        File file = getFile("/anagrams/wordlist_338882.txt");
        Words words = WordReader.from(file).asWords();
        Anagrams anagrams = new Anagrams(words);

        // when
        List<Anagram> anagramList = anagrams.arrange();

        // then
        assertThat(anagramList).isNotEmpty();
        assertThat(anagramList.size()).isEqualTo(20683);
        assertThat(this.countWords(anagramList)).isEqualTo(48162);
    }

    private int countWords(List<Anagram> anagramList) {
        return anagramList.stream().map(a -> a.asList().size()).reduce(Integer::sum).get();
    }

    private File getFile(String s) {
        return new File(ConferenceManagerTest.class.getResource(s).getPath());
    }
    /******************* arrange test end *****************/


    /******************* longest test start *****************/
    @Test
    public void should_return_longest_words() {
        // given
        Words words = Words.of(
                "kinship", "pinkish",
                "enlist", "inlets", "listen", "silent",
                "boaster", "boaters", "borates",
                "fresher", "refresh",
                "sinks", "skins",
                "knits", "stink",
                "rots", "sort",
                "anagrams", "gramanas"
        );
        Anagrams anagrams = new Anagrams(words);
        List<Anagram> anagramList = anagrams.arrange();

        // when
        Anagram longestAnagram = anagrams.longest(anagramList);

        // then
        Anagram givenResult = Anagram.of("gramanas", "anagrams");
        assertAnagramsEquals(Arrays.asList(longestAnagram), Arrays.asList(givenResult));
    }
    /******************* longest test end *****************/


    /******************* most test start *****************/
    @Test
    public void should_return_most_words() {
        // given
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
        List<Anagram> anagramList = anagrams.arrange();

        // when
        Anagram anagram = anagrams.most(anagramList);

        // then
        Anagram givenResult = Anagram.of("abc", "acb", "bca", "bac", "cab", "cba");
        assertAnagramsEquals(Arrays.asList(anagram), Arrays.asList(givenResult));
    }

    /******************* most test end *****************/


    private void assertAnagramsEquals(List<Anagram> sourceList, List<Anagram> targetList) {
        List<String> sourceAnagrams = asStringList(sourceList);

        List<String> targetAnagrams = asStringList(targetList);

        assertThat(sourceAnagrams).isEqualTo(targetAnagrams);
    }

    private List<String> asStringList(List<Anagram> sourceList) {
        return sourceList.stream()
                .map(Anagram::asList)
                .flatMap(list -> list.stream())
                .sorted()
                .collect(toList());
    }
}
