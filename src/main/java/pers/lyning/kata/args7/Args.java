package pers.lyning.kata.args7;

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

    public static Args parse(String[] arguments) {
        Map<String, String> flagToValueMap = new HashMap<>();
        for (int index = 0; index < arguments.length; index++) {
            if (isFlag(arguments[index])) {
                String flag = arguments[index].substring(1);
                String values = hasValue(arguments, index + 1) ? arguments[index += 1] : null;
                flagToValueMap.put(flag, values);
            }
        }
        return new Args(flagToValueMap);
    }

    private static boolean hasValue(String[] arguments, int valueIndex) {
        return !stackOverflow(arguments, valueIndex)
                && !isFlag(arguments[valueIndex]);
    }

    private static boolean stackOverflow(String[] arguments, int valueIndex) {
        return arguments.length - 1 < valueIndex;
    }

    private static boolean isFlag(String argument) {
        return argument.startsWith("-") && argument.length() == 2;
    }

    public boolean hasFlag(String flag) {
        return flagToValueMap.containsKey(flag);
    }

    public String getValue(String flag) {
        return flagToValueMap.get(flag);
    }
}
