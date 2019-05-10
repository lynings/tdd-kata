package pers.lyning.kata.args;

import pers.lyning.kata.args.exception.ArgsException;

import java.util.ListIterator;

/**
 * @author lyning
 */
public class Arg {
    private final Character flag;
    private final String value;

    private Arg(Character flag, String value) {
        this.flag = flag;
        this.value = value;
    }

    public static Arg parse(ListIterator<String> iterator) {
        Character flag = getFlag(iterator);
        String value = iterator.hasNext() ? getValue(iterator) : null;
        return new Arg(flag, value);
    }

    private static Character getFlag(ListIterator<String> iterator) {
        String flag = iterator.next();
        if (!isFlag(flag)) {
            throw new ArgsException("Incorrect flag.");
        }
        return flag.substring(1).charAt(0);
    }

    private static String getValue(ListIterator<String> iterator) {
        String value = iterator.next();
        if (isValue(value)) {
            return value;
        }
        iterator.previous();
        return null;
    }

    private static boolean isValue(String value) {
        return !isFlag(value);
    }

    private static boolean isFlag(String arg) {
        return arg.startsWith("-") && Character.isLetter(arg.charAt(1));
    }

    public Character flag() {
        return this.flag;
    }

    public String value() {
        return this.value;
    }
}
