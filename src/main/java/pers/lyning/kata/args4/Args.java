package pers.lyning.kata.args4;

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
        Map<String, String> flagToValueMap = new HashMap<>(args.length / 2);
        for (int index = 0; index < args.length; index++) {
            if (isFlag(args[index])) {
                String flag = args[index].substring(1);
                String value = hasValue(args, index + 1) ? args[index += 1] : null;
                flagToValueMap.put(flag, value);
            }
        }
        return new Args(flagToValueMap);
    }

    private static boolean hasValue(String[] args, int valueIndex) {
        return valueIndex <= args.length - 1 && !isFlag(args[valueIndex]);
    }

    private static boolean isFlag(String arg) {
        return arg.startsWith("-") && arg.length() == 2 && Character.isLetter(arg.charAt(1));
    }

    public int size() {
        return this.flagToValueMap.size();
    }

    public boolean hasFlag(String flag) {
        return this.flagToValueMap.containsKey(flag);
    }

    public String getValue(String flag) {
        return this.flagToValueMap.get(flag);
    }
}
