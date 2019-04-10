package pers.lyning.kata.merchantguidetothegalaxy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class SymbolCalculatorTest {

    private final SymbolCalculator calculator = new SymbolCalculator();

    @Test
    public void should_return_2000_when_input_MM() {
        Integer number = calculator.calc("MM");
        assertThat(number).isEqualTo(2000);
    }

    @Test
    public void should_return_4_when_input_IV() {
        Integer number = calculator.calc("IV");
        assertThat(number).isEqualTo(4);
    }

    @Test
    public void should_return_2006_when_input_MMVI() {
        Integer number = calculator.calc("MMVI");
        assertThat(number).isEqualTo(2006);
    }

    @Test
    public void should_return_2004_when_input_IVMM() {
        Integer number = calculator.calc("IVMM");
        assertThat(number).isEqualTo(2004);
    }

    @Test
    public void should_return_1944_when_input_MCMXLIV() {
        Integer number = calculator.calc("MCMXLIV");
        assertThat(number).isEqualTo(1944);
    }

    @Test
    public void should_return_39_when_input_XXXIX() {
        Integer number = calculator.calc("XXXIX");
        assertThat(number).isEqualTo(39);
    }
}
