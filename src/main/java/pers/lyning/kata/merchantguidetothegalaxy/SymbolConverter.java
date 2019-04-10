package pers.lyning.kata.merchantguidetothegalaxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
public class SymbolConverter {

    public static final Map<String, Integer> table = new HashMap() {{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};

    public Integer convert(String symbol) {
        return table.get(symbol);
    }
}
