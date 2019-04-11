package pers.lyning.kata.merchantguidetothegalaxy;

import org.junit.Rule;
import org.junit.Test;
import pers.lyning.kata.testing.SystemOutputCapture;
import pers.lyning.kata.utils.FileContentReader;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class GalaxyGuideTest {

    @Rule
    public SystemOutputCapture outputCapture = new SystemOutputCapture();

    @Test
    public void should_return_42_when_given_pish_tegj_glob_glob() throws Exception {
        File file = new File(this.getClass().getResource("/merchantguidetothegalaxy/should_convert_success_full_input.txt").getPath());
        String text = FileContentReader.getString(file);
        GalaxyGuide galaxyGuide = new GalaxyGuide();
        galaxyGuide.receive(text);
        galaxyGuide.display();

        assertThat(outputCapture.toString())
                .contains("pish tegj glob glob is 42")
                .contains("glob prok Silver is 68 Credits")
                .contains("glob prok Gold is 57800 Credits")
                .contains("glob prok Iron is 782 Credits")
                .contains("I have no idea what you are talking about");
    }
}
