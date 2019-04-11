package pers.lyning.kata.merchantguidetothegalaxy;

import org.junit.Test;
import pers.lyning.kata.utils.FileContentReader;

import java.io.File;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class InputHandlerTest {

    @Test
    public void should_convert_success() throws Exception {
        File file = new File(this.getClass().getResource("/merchantguidetothegalaxy/should_convert_success_full_input.txt").getPath());
        String text = FileContentReader.getString(file);

        InputHandler inputHandler = new InputHandler();
        inputHandler.handle(text);
        List<String> questions = inputHandler.getQuestions();
        assertThat(questions).isNotEmpty();
        assertThat(questions.size()).isEqualTo(5);
        assertThat(questions.get(0)).isEqualTo("how much is pish tegj glob glob ?");
        assertThat(questions.get(1)).isEqualTo("how many Credits is glob prok Silver ?");
        assertThat(questions.get(2)).isEqualTo("how many Credits is glob prok Gold ?");
        assertThat(questions.get(3)).isEqualTo("how many Credits is glob prok Iron ?");
        assertThat(questions.get(4)).isEqualTo("how much wood could a woodchuck chuck if a woodchuck could chuckwood ?");

        Map<String, String> wordToSymbolMap = inputHandler.getWordToSymbolMap();
        assertThat(wordToSymbolMap.size()).isEqualTo(4);
        assertThat(wordToSymbolMap.get("glob")).isEqualTo("I");
        assertThat(wordToSymbolMap.get("prok")).isEqualTo("V");
        assertThat(wordToSymbolMap.get("pish")).isEqualTo("X");
        assertThat(wordToSymbolMap.get("tegj")).isEqualTo("L");

        List<String> metalsCreditsLineList = inputHandler.getMetalsCreditsLineList();
        assertThat(metalsCreditsLineList.size()).isEqualTo(3);
        assertThat(metalsCreditsLineList.get(0)).isEqualTo("glob glob Silver is 34 Credits");
        assertThat(metalsCreditsLineList.get(1)).isEqualTo("glob prok Gold is 57800 Credits");
        assertThat(metalsCreditsLineList.get(2)).isEqualTo("pish pish Iron is 3910 Credits");
    }
}
