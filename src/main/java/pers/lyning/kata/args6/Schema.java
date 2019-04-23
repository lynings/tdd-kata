package pers.lyning.kata.args6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * @author lyning
 */
public class Schema {
    private Map<String, String> flagToSchemaMap;

    private Schema(Map<String, String> flagToSchemaMap) {
        this.flagToSchemaMap = flagToSchemaMap;
    }

    public static Schema parse(String schemas) {
        if (schemas.isEmpty()) {
            return new Schema(new HashMap<>(0));
        }
        Map<String, String> flagToSchemaMap = Arrays
                .asList(schemas.split(","))
                .stream()
                .map(s -> s.trim())
                .collect(toMap(s -> s.substring(0, 1), s -> s.substring(1)));
        return new Schema(flagToSchemaMap);
    }

    public int size() {
        return this.flagToSchemaMap.size();
    }

    public String get(String flag) {
        return this.flagToSchemaMap.get(flag);
    }
}
