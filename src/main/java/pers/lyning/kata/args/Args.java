package pers.lyning.kata.args;

import pers.lyning.kata.args.exception.ArgsException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

/**
 * @author lyning
 */
public class Args {
    private Map<Character, String> flagToValueMap;

    private Args(Map<Character, String> flagToValueMap) {
        this.flagToValueMap = flagToValueMap;
    }

    public static Args parse(String[] args) {
        Map<Character, String> flagToValueMap = new HashMap<>();
        for (ListIterator<String> iterator = Arrays.asList(args).listIterator(); iterator.hasNext(); ) {
            Arg arg = Arg.parse(iterator);
            flagToValueMap.put(arg.flag(), arg.value());
        }
        return new Args(flagToValueMap);
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
