package pers.lyning.kata.merchantguidetothegalaxy;

import org.junit.Test;
import pers.lyning.kata.merchantguidetothegalaxy.validator.RepeatedThreeTimesConstraintValidator;
import pers.lyning.kata.merchantguidetothegalaxy.validator.SymbolsConstraintValidator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class RepeatedThreeTimesConstraintValidatorTest {
    private SymbolsConstraintValidator symbolsConstraintValidator = new RepeatedThreeTimesConstraintValidator();

    @Test
    public void check_I_X_C_and_M_can_be_repeated_3_times() {
        assertThat(symbolsConstraintValidator.validate("III")).isTrue();
        assertThat(symbolsConstraintValidator.validate("XXX")).isTrue();
        assertThat(symbolsConstraintValidator.validate("CCC")).isTrue();
        assertThat(symbolsConstraintValidator.validate("MMM")).isTrue();
    }

    @Test
    public void check_I_X_C_and_M_can_not_repeated_more_than_3_times() {
        assertThat(symbolsConstraintValidator.validate("IIII")).isFalse();
        assertThat(symbolsConstraintValidator.validate("XXXX")).isFalse();
        assertThat(symbolsConstraintValidator.validate("CCCC")).isFalse();
        assertThat(symbolsConstraintValidator.validate("MMMM")).isFalse();
        assertThat(symbolsConstraintValidator.validate("MMMMM")).isFalse();
    }

    @Test
    public void check_XXXIX_can_be_repeated_4_times() {
        assertThat(symbolsConstraintValidator.validate("XXXIX")).isTrue();
        assertThat(symbolsConstraintValidator.validate("XXXIVIX")).isTrue();
    }
}
