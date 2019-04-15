package pers.lyning.kata.args;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
public class Args {
    private Map<String, String> flagToValueMap;

    private Args(Map<String, String> flagToValueMap) {
        this.flagToValueMap = flagToValueMap;
    }

    public String getValue(String flag) {
        if (!this.containsFlag(flag)) {
            throw new ArgsException("INVALID FLAG");
        }
        return this.flagToValueMap.get(flag);
    }

    public boolean containsFlag(String flag) {
        return this.flagToValueMap.containsKey(flag);
    }

    public static Args parse(String[] args) {
        Map<String, String> flagToValueMap = new HashMap<>();
        for (int index = 0, len = args.length; index < len; index++) {
            if (isFlag(args[index])) {
                String flag = args[index];
                String value = hasValue(args, index) ? args[index += 1] : null;
                flagToValueMap.put(flag.substring(1), value);
            }
        }
        return new Args(flagToValueMap);
    }

    private static boolean hasValue(String[] args, int index) {
        return index + 1 <= args.length - 1;
    }

    private static boolean isFlag(String charString) {
        return charString.startsWith("-")
                && Character.isLetter(charString.charAt(1));
    }
}
