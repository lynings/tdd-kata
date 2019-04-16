package pers.lyning.kata.args4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
public class Schema {
    private Map<String, String> flagToSchemaMap;

    private Schema(Map<String, String> flagToSchemaMap) {
        this.flagToSchemaMap = flagToSchemaMap;
    }

    public static Schema parse(String schemas) {
        String[] schemaArr = schemas.split(",");
        Map<String, String> flagToSchemaMap = new HashMap<>();
        for (String str : schemaArr) {
            String flag = str.trim().substring(0, 1);
            String schema = str.trim().substring(1);
            flagToSchemaMap.put(flag, schema);
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

    public int size() {
        return this.flagToSchemaMap.size();
    }
}
