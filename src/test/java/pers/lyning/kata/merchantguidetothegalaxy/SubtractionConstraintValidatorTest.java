package pers.lyning.kata.merchantguidetothegalaxy;

import org.junit.Test;
import pers.lyning.kata.merchantguidetothegalaxy.validator.SubtractionConstraintValidator;
import pers.lyning.kata.merchantguidetothegalaxy.validator.SymbolsConstraintValidator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class SubtractionConstraintValidatorTest {
    private SymbolsConstraintValidator validator = new SubtractionConstraintValidator();

    @Test
    public void check_I_can_be_subtracted_from_V_and_X_only() {
        assertThat(validator.validate("IX")).isTrue();
        assertThat(validator.validate("IV")).isTrue();
    }

    @Test
    public void check_I_cannot_be_subtracted_from_L_C_D_M() {
        assertThat(validator.validate("IL")).isFalse();
        assertThat(validator.validate("IC")).isFalse();
        assertThat(validator.validate("ID")).isFalse();
        assertThat(validator.validate("IM")).isFalse();
    }

    @Test
    public void check_symbol_length_must_equals_2() {
        assertThat(validator.validate("IVL")).isFalse();
        assertThat(validator.validate("IXC")).isFalse();
    }

    @Test
    public void check_C_can_be_subtracted_from_D_and_M_only() {
        assertThat(validator.validate("CD")).isTrue();
        assertThat(validator.validate("CM")).isTrue();
    }

    @Test
    public void check_D_cannot_be_subtracted_from_V_X_L_C() {
        assertThat(validator.validate("DV")).isFalse();
        assertThat(validator.validate("DX")).isFalse();
        assertThat(validator.validate("DL")).isFalse();
        assertThat(validator.validate("DC")).isFalse();
    }

    @Test
    public void check_X_can_be_subtracted_from_L_and_C_only() {
        assertThat(validator.validate("XL")).isTrue();
        assertThat(validator.validate("XC")).isTrue();
    }

    @Test
    public void check_X_cannot_be_subtracted_from_L_C_D_M() {
        assertThat(validator.validate("XI")).isFalse();
        assertThat(validator.validate("XV")).isFalse();
        assertThat(validator.validate("XD")).isFalse();
        assertThat(validator.validate("XM")).isFalse();
    }

    @Test
    public void all_symbols_cannot_be_subtracted_from_V_L_D() {
        assertThat(validator.validate("VX")).isFalse();
        assertThat(validator.validate("LC")).isFalse();
        assertThat(validator.validate("DM")).isFalse();
    }
}
