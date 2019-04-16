package pers.lyning.kata.args5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
public class Args {

    private Map<String, String> flagToValueMap;

    public Args(Map<String, String> flagToValueMap) {
        this.flagToValueMap = flagToValueMap;
    }

    public static Args parse(String[] args) {
        Map<String, String> flagToValueMap = new HashMap<>();
        for (int index = 0; index < args.length; index++) {
            if (isFlag(args[index])) {
                String flag = args[index].substring(1);
                String value = isValue(args, index + 1) ? args[index += 1] : null;
                flagToValueMap.put(flag, value);
            }
        }
        return new Args(flagToValueMap);
    }

    private static boolean isValue(String[] args, int index) {
        return index <= args.length - 1 && !isFlag(args[index]);
    }

    private static boolean isFlag(String arg) {
        arg = arg.trim();
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
