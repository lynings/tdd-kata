package pers.lyning.kata.args.valueparser;

import java.util.Objects;

/**
 * @author lyning
 */
public class StringArraysValueParser implements ValueParser<String[]> {

    @Override
    public String getDescription() {
        return "schema '[*]' default return empty string array(such as schema: s[*], args: -s), when value existed then return specified string array(such as schema: s[*], args: -s hello world).";
    }

    @Override
    public String[] parse(String values) {
        if (Objects.isNull(values)) {
            return new String[]{};
        }
        return values.split(" ");
    }
}
