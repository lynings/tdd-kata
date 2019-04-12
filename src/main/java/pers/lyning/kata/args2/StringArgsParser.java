package pers.lyning.kata.args2;

import java.util.Optional;

/**
 * @author lyning
 */
public class StringArgsParser implements ArgsParser<String> {

    @Override
    public String parse(String values) {
        return Optional
                .ofNullable(values)
                .orElse("");
    }
}
