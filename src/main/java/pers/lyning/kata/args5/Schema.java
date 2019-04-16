package pers.lyning.kata.args5;

import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * @author lyning
 */
public class Schema {

    private Map<String, String> flagToSchemaMap;

    public Schema(Map<String, String> flagToSchemaMap) {
        this.flagToSchemaMap = flagToSchemaMap;
    }

    public static Schema parse(String schemas) {
        if (Strings.isNullOrEmpty(schemas)) {
            return new Schema(new HashMap<>(0));
        }

        Map<String, String> flagToSchemaMap = Arrays
                .asList(schemas.split(","))
                .stream()
                .map(String::trim)
                .collect(toMap(a -> a.substring(0, 1), a -> a.substring(1)));
        return new Schema(flagToSchemaMap);
    }

    public int size() {
        return this.flagToSchemaMap.size();
    }

    public String get(String flag) {
        return this.flagToSchemaMap.get(flag);
    }
}
