package pers.lyning.kata.merchantguidetothegalaxy;

import org.junit.Test;
import pers.lyning.kata.utils.FileContentReader;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class InputHandlerTest {

    @Test
    public void should_convert_success() throws IOException {
        File file = new File(this.getClass().getResource("/merchantguidetothegalaxy/should_convert_success_full_input.txt").getPath());
        String text = FileContentReader.getString(file);

        InputHandler inputHandler = new InputHandler();
        inputHandler.convert(text);
        List<String> questions = inputHandler.getQuestions();
        assertThat(questions).isNotEmpty();
        assertThat(questions.size()).isEqualTo(5);
        for (String question : questions) {
            assertThat(question).startsWith("how");
            assertThat(question).endsWith("?");
        }

        Map<String, String> wordToSymbolMap = inputHandler.getWordToSymbolMap();
        assertThat(wordToSymbolMap.size()).isEqualTo(4);
        assertThat(wordToSymbolMap.get("glob")).isEqualTo("I");
        assertThat(wordToSymbolMap.get("prok")).isEqualTo("V");
        assertThat(wordToSymbolMap.get("pish")).isEqualTo("X");
        assertThat(wordToSymbolMap.get("tegj")).isEqualTo("L");

        Map<String, Double> metalsToAvgCreditsMap = inputHandler.getMetalsToAvgCreditsMap();
        assertThat(metalsToAvgCreditsMap.size()).isEqualTo(3);
        assertThat(metalsToAvgCreditsMap.get("Silver")).isEqualTo(17.0);
        assertThat(metalsToAvgCreditsMap.get("Gold")).isEqualTo(14450.0);
        assertThat(metalsToAvgCreditsMap.get("Iron")).isEqualTo(195.5);
    }
}
