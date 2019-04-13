package pers.lyning.kata.args2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
public class ArgsParser {

    private final String[] args;
    private Map<String, String> flagToValuesMap = new HashMap<>();

    public ArgsParser(String[] args) {
        this.args = args;
        this.parse();
    }

    private void parse() {
        for (int index = 0, len = args.length; index < len; index++) {
            if (this.isFlag(args[index])) {
                String flag = args[index];
                String value = this.hasValue(index) ? args[index += 1] : null;
                this.flagToValuesMap.put(flag.substring(1), value);
            }
        }
    }

    public String getValue(String flag) {
        return this.flagToValuesMap.get(flag);
    }

    public boolean hasFlag(String flag) {
        return this.flagToValuesMap.containsKey(flag);
    }

    private boolean hasValue(int index) {
        return index + 1 <= args.length - 1;
    }

    private boolean isFlag(String charString) {
        return charString.startsWith("-")
                && Character.isLetter(charString.charAt(1));
    }
}
