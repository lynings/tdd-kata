package pers.lyning.kata.merchantguidetothegalaxy;

import org.junit.Test;
import pers.lyning.kata.merchantguidetothegalaxy.validator.RepeatedOneTimesConstraintValidator;
import pers.lyning.kata.merchantguidetothegalaxy.validator.SymbolsConstraintValidator;

import static org.assertj.core.api.Assertions.assertThat;

public class RepeatedOneTimesConstraintValidatorTest {
    private SymbolsConstraintValidator symbolsConstraintValidator = new RepeatedOneTimesConstraintValidator();

    @Test
    public void check_D_L_and_V_can_never_be_repeated() {
        assertThat(symbolsConstraintValidator.validate("DD")).isFalse();
        assertThat(symbolsConstraintValidator.validate("DID")).isFalse();

        assertThat(symbolsConstraintValidator.validate("LL")).isFalse();
        assertThat(symbolsConstraintValidator.validate("LIL")).isFalse();

        assertThat(symbolsConstraintValidator.validate("VV")).isFalse();
        assertThat(symbolsConstraintValidator.validate("VIV")).isFalse();
    }
}