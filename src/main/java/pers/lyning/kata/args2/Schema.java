package pers.lyning.kata.args2;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * @author lyning
 */
public class Schema {
    private final Map<String, String> flagToSchemaMap;

    private Schema(Map<String, String> flagToSchemaMap) {
        this.flagToSchemaMap = flagToSchemaMap;
    }

    public static Schema parse(String schema) {
        Map<String, String> flagToSchemaMap = Arrays.asList(schema.split(","))
                .stream()
                .collect(toMap(s -> s.substring(0, 1), s -> s.substring(1)));
        return new Schema(flagToSchemaMap);
    }

    public String get(String flag) {
        return this.flagToSchemaMap.get(flag);
    }
}
