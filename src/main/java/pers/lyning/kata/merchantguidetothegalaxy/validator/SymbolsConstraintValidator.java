package pers.lyning.kata.merchantguidetothegalaxy.validator;

/**
 * @author lyning
 */
public interface SymbolsConstraintValidator {

    /**
     * 用于验证符号是否符合要求
     *
     * @param symbols 例如 IV
     * @return
     */
    boolean validate(String symbols);
}
