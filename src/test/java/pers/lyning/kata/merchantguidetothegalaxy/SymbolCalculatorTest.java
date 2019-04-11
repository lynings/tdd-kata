package pers.lyning.kata.merchantguidetothegalaxy;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class SymbolCalculatorTest {

    @Rule
    public final ExpectedException exceptionEx = ExpectedException.none();

    private final SymbolCalculator calculator = new SymbolCalculator();

    @Test
    public void should_return_2000_when_input_MM() throws Exception {
        Integer number = calculator.calc("MM");
        assertThat(number).isEqualTo(2000);
    }

    @Test
    public void should_return_4_when_input_IV() throws Exception {
        Integer number = calculator.calc("IV");
        assertThat(number).isEqualTo(4);
    }

    @Test
    public void should_return_2006_when_input_MMVI() throws Exception {
        Integer number = calculator.calc("MMVI");
        assertThat(number).isEqualTo(2006);
    }

    @Test
    public void should_return_2004_when_input_IVMM() throws Exception {
        Integer number = calculator.calc("IVMM");
        assertThat(number).isEqualTo(2004);
    }

    @Test
    public void should_return_1944_when_input_MCMXLIV() throws Exception {
        Integer number = calculator.calc("MCMXLIV");
        assertThat(number).isEqualTo(1944);
    }

    @Test
    public void should_return_39_when_input_XXXIX() throws Exception {
        Integer number = calculator.calc("XXXIX");
        assertThat(number).isEqualTo(39);
    }

    @Test
    public void should_fail_when_input_VX() throws Exception {
        exceptionEx.expect(RuntimeException.class);
        exceptionEx.expectMessage("V cannot subtracted by X");
        this.calculator.calc("VX");
    }

    @Test
    public void should_fail_when_input_DD() throws Exception {
        exceptionEx.expect(Exception.class);
        exceptionEx.expectMessage("\"D\", \"L\", and \"V\" can never be repeated.");
        this.calculator.calc("DD");
    }

    @Test
    public void should_fail_when_input_IIII() throws Exception {
        exceptionEx.expect(Exception.class);
        exceptionEx.expectMessage("The symbols \"I\", \"X\", \"C\", and \"M\" can be repeated three times in succession, but no more. (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.)");
        this.calculator.calc("IIII");
    }
}
