package pers.lyning.kata.args.valueparser;

import java.util.Optional;

/**
 * @author lyning
 */
public class StringValueParser implements ValueParser<String> {

    @Override
    public String getDescription() {
        return "schema '*' default return empty string(such as schema: s*, args: -s), when value existed then return specified string value(such as schema: s*, args: -s HelloWorld!!!).";
    }

    @Override
    public String parse(String values) {
        return Optional
                .ofNullable(values)
                .orElse("");
    }
}
