package pers.lyning.kata.args;

import java.util.Objects;

/**
 * @author lyning
 */
public class BooleanValueParser implements ValueParser<Boolean> {

    @Override
    public Boolean parse(String values) {
        return !Objects.isNull(values);
    }
}
