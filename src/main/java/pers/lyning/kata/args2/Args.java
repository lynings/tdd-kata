package pers.lyning.kata.args2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
public class Args {
    private final Map<String, String> flagToValueMap;

    private Args(Map<String, String> flagToValueMap) {
        this.flagToValueMap = flagToValueMap;
    }

    public static Args parse(String[] args) {
        Map<String, String> flagToValueMap = new HashMap<>();
        for (String arg : Arrays.asList(args)) {
            String flag = arg.substring(1, 2);
            String value = hasValue(arg) ? arg.substring(2).trim() : null;
            flagToValueMap.put(flag, value);
        }
        return new Args(flagToValueMap);
    }

    private static boolean hasValue(String arg) {
        return arg.trim().length() > 2;
    }

    public boolean containsFlag(String flag) {
        return this.flagToValueMap.containsKey(flag);
    }

    public String getValue(String flag) {
        return this.flagToValueMap.get(flag);
    }
}
