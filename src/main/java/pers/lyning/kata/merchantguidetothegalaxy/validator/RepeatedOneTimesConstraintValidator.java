package pers.lyning.kata.merchantguidetothegalaxy.validator;

import java.util.Arrays;
import java.util.List;

/**
 * @author lyning
 */
public class RepeatedOneTimesConstraintValidator implements SymbolsConstraintValidator {

    private final List<String> SYMBOLS = Arrays.asList("D", "L", "V");

    @Override
    public boolean validate(String symbols) {
        for (String symbol : SYMBOLS) {
            Integer repeatTimes = this.calcRepeatTimes(symbols, symbol);
            if (repeatTimes > 1) {
                return false;
            }
        }
        return true;
    }

    private Integer calcRepeatTimes(String source, String target) {
        return source.length() - source.replace(target, "").length();
    }
}
