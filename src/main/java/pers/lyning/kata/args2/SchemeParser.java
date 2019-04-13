package pers.lyning.kata.args2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lyning
 */
public class SchemeParser {

    private final String schema;
    private Map<String, String> flagToSchemaMap = new HashMap<>();

    public SchemeParser(String schema) {
        this.schema = schema;
        this.parse();
    }

    private void parse() {
        String[] schemaArr = this.schema.split(",");
        for (String str : schemaArr) {
            this.flagToSchemaMap.put(str.substring(0, 1), str.substring(1));
        }
    }

    public String getSchema(String flag) {
        return this.flagToSchemaMap.get(flag);
    }

    public List<String> getSchemas() {
        return new ArrayList<>(flagToSchemaMap.values());
    }
}
