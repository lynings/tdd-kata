package pers.lyning.kata.args;

import java.util.Objects;

/**
 * @author lyning
 */
public class StringArraysValueParser implements ValueParser<String[]> {

    @Override
    public String[] parse(String values) {
        if (Objects.isNull(values)) {
            return new String[]{};
        }
        return values.split(" ");
    }
}
