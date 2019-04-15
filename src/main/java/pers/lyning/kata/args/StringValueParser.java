package pers.lyning.kata.args;

import java.util.Optional;

/**
 * @author lyning
 */
public class StringValueParser implements ValueParser<String> {

    @Override
    public String parse(String values) {
        return Optional
                .ofNullable(values)
                .orElse("");
    }
}
