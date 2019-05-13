package pers.lyning.kata.args.valueparser;

import java.util.Objects;

/**
 * @author lyning
 */
public class BooleanValueParser implements ValueParser<Boolean> {

    @Override
    public String getDescription() {
        return "default return false(such as schema: b, args: -b), when value existed then return true(such as schema: b, args: -b 1).";
    }

    @Override
    public Boolean parse(String values) {
        return !Objects.isNull(values);
    }
}
