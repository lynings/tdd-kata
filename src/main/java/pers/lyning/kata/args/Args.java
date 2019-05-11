package pers.lyning.kata.args;

import pers.lyning.kata.args.exception.ArgsException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
public class Args {
    private final Map<Character, String> flagToValueMap;
    private final String[] args;

    public Args(String[] args) {
        this.args = args;
        this.flagToValueMap = new HashMap<>();
        this.parse();
    }

    private void parse() {
        for (int index = 0; index < args.length; index++) {
            Character flag = parseFlag(args[index]);
            String value = hasValue(index + 1) ? args[index += 1] : null;
            flagToValueMap.put(flag, value);
        }
    }

    private boolean hasValue(int valueIndex) {
        return valueIndex < args.length && !isFlag(args[valueIndex]);
    }

    private Character parseFlag(String arg) {
        if (!isFlag(arg)) {
            throw new ArgsException("INCORRECT FLAG");
        }
        return arg.substring(1).charAt(0);
    }

    private boolean isFlag(String charString) {
        return charString.startsWith("-")
                && Character.isLetter(charString.charAt(1));
    }

    public String getValue(Character flag) {
        if (!this.containsFlag(flag)) {
            throw new ArgsException("INVALID FLAG");
        }
        return this.flagToValueMap.get(flag);
    }

    public boolean containsFlag(Character flag) {
        return this.flagToValueMap.containsKey(flag);
    }
}
