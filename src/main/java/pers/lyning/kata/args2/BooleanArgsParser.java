package pers.lyning.kata.args2;

import java.util.Objects;

/**
 * @author lyning
 */
public class BooleanArgsParser implements ArgsParser<Boolean> {

    @Override
    public Boolean parse(String values) {
        return !Objects.isNull(values);
    }
}
