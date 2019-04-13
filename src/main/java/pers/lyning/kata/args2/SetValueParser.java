package pers.lyning.kata.args2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * @author lyning
 */
public class SetValueParser implements ValueParser<Set<String>> {

    @Override
    public Set<String> parse(String values) {
        if (Objects.isNull(values)) {
            return new HashSet<>(0);
        }
        return Arrays
                .asList(values.split(" "))
                .stream()
                .collect(toSet());
    }
}
