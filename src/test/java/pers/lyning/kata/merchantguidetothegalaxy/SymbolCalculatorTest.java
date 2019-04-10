package pers.lyning.kata.merchantguidetothegalaxy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class SymbolCalculatorTest {

    @Test
    public void should_return_2000_when_input_MM() {
        SymbolCalculator calculator = new SymbolCalculator();
        Integer number = calculator.calc("MM");
        assertThat(number).isEqualTo(2000);
    }

    @Test
    public void should_return_4_when_input_IV() {
        SymbolCalculator calculator = new SymbolCalculator();
        Integer number = calculator.calc("IV");
        assertThat(number).isEqualTo(4);
    }

    @Test
    public void should_return_2006_when_input_MMVI() {
        SymbolCalculator calculator = new SymbolCalculator();
        Integer number = calculator.calc("MMVI");
        assertThat(number).isEqualTo(2006);
    }
}
