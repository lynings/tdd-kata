package pers.lyning.kata.args2;

import java.util.Objects;

/**
 * @author lyning
 */
public class StringArraysArgsParser implements ArgsParser<String[]> {

    @Override
    public String[] parse(String values) {
        if (Objects.isNull(values)) {
            return new String[]{};
        }
        return values.split(" ");
    }
}
