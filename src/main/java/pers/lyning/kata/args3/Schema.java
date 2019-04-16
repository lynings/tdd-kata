package pers.lyning.kata.args3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
public class Schema {
    private final Map<String, String> flagToSchemaMap;

    private Schema(Map<String, String> flagToSchemaMap) {
        this.flagToSchemaMap = flagToSchemaMap;
    }

    public static Schema parse(String schemas) {
        String[] schemasArr = schemas.split(",");
        Map<String, String> flagToSchemaMap = new HashMap<>(schemasArr.length);
        for (String schema : schemasArr) {
            String flag = schema.substring(0, 1);
            String value = schema.substring(1);
            flagToSchemaMap.put(flag, value);
        }
        return new Schema(flagToSchemaMap);
    }

    public boolean has(String schema) {
        return this.flagToSchemaMap.values().contains(schema);
    }

    public boolean hasFlag(String flag) {
        return this.flagToSchemaMap.containsKey(flag);
    }

    public String get(String flag) {
        return this.flagToSchemaMap.get(flag);
    }
}
