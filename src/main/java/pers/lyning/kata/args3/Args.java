package pers.lyning.kata.args3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
public class Args {
    private final Map<String, String> flagToValueMap;

    public Args(Map<String, String> flagToValueMap) {
        this.flagToValueMap = flagToValueMap;
    }

    public static Args parse(String[] args) {
        Map<String, String> flagToValueMap = new HashMap<>(args.length / 2);
        for (int index = 0; index < args.length; index++) {
            if (isFlag(args, index)) {
                String flag = getFlag(args[index]);
                String value = hasValue(args, index + 1) ? args[index += 1] : null;
                flagToValueMap.put(flag, value);
            }
        }
        return new Args(flagToValueMap);
    }

    public boolean hasFlag(String flag) {
        return flagToValueMap.containsKey(flag);
    }

    public String getValue(String flag) {
        return flagToValueMap.get(flag);
    }

    private static boolean hasValue(String[] args, int valueIndex) {
        return valueIndex <= args.length - 1 && !isFlag(args, valueIndex);
    }

    private static boolean isFlag(String[] argArr, int index) {
        String arg = argArr[index];
        return arg.startsWith("-") && Character.isLetter(arg.charAt(1));
    }

    private static String getFlag(String arg) {
        return arg.substring(1);
    }
}
