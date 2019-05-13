package pers.lyning.kata.args;

import pers.lyning.kata.args.exception.ArgsException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
public class ArgsParser {

    private final String[] args;
    private final Map<Character, String> flagToValueMap;

    public ArgsParser(String[] args) {
        this.args = args;
        this.flagToValueMap = new HashMap<>();
        this.parse();
    }

    public String getValue(Character flag) {
        if (!this.flagToValueMap.containsKey(flag)) {
            throw new ArgsException("INVALID FLAG");
        }
        return this.flagToValueMap.get(flag);
    }

    private boolean hasValue(int valueIndex) {
        return valueIndex < this.args.length
                && !this.isFlag(this.args[valueIndex]);
    }

    private boolean isFlag(String charString) {
        return charString.startsWith("-")
                && Character.isLetter(charString.charAt(1));
    }

    private void parse() {
        for (int index = 0; index < this.args.length; index++) {
            Character flag = this.parseFlag(this.args[index]);
            String value = this.hasValue(index + 1) ? this.args[index += 1] : null;
            this.flagToValueMap.put(flag, value);
        }
    }

    private Character parseFlag(String arg) {
        if (!this.isFlag(arg)) {
            throw new ArgsException("INCORRECT FLAG");
        }
        return arg.substring(1).charAt(0);
    }
}
