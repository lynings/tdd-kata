package pers.lyning.kata.args;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * @author lyning
 */
public class Schemas {
    private final Map<Character, String> flagToSchemaMap;

    private Schemas(Map<Character, String> flagToSchemaMap) {
        this.flagToSchemaMap = flagToSchemaMap;
    }

    public static Schemas parse(String schema) {
        Map<Character, String> flagToSchemaMap = Arrays.asList(schema.split(","))
                .stream()
                .map(Schema::new)
                .collect(toMap(Schema::flag, Schema::name));
        return new Schemas(flagToSchemaMap);
    }

    public String get(Character flag) {
        return this.flagToSchemaMap.get(flag);
    }
}
