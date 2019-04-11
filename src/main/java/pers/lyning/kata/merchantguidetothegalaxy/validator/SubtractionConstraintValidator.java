package pers.lyning.kata.merchantguidetothegalaxy.validator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lyning
 */
public class SubtractionConstraintValidator implements SymbolsConstraintValidator {

    private final Map<String, Set<String>> symbolToCanSubtractedSymbolMap = new HashMap() {{
        put("I", new HashSet() {{
            add("V");
            add("X");
        }});
        put("C", new HashSet() {{
            add("D");
            add("M");
        }});
        put("X", new HashSet() {{
            add("L");
            add("C");
        }});
    }};

    private final Set<String> CANNOT_SUBTRACTED_SYMBOLS = new HashSet() {{
        add("V");
        add("L");
        add("D");
    }};

    private final int SYMBOL_LENGTH = 2;

    @Override
    public boolean validate(String symbols) {
        String[] symbolsArr = symbols.split("");
        if (symbolsArr.length != SYMBOL_LENGTH) {
            return false;
        }
        String subtractedSymbol = symbolsArr[0];
        String symbol = symbolsArr[1];
        return !CANNOT_SUBTRACTED_SYMBOLS.contains(subtractedSymbol)
                && symbolToCanSubtractedSymbolMap.containsKey(subtractedSymbol)
                && symbolToCanSubtractedSymbolMap.get(subtractedSymbol).contains(symbol);
    }
}
