package pers.lyning.kata.args2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
public class Args {
    private final String schema;
    private final String[] args;
    private Map<String, String> flagToValuesMap = new HashMap<>();
    private Map<String, String> flagToSchemaMap = new HashMap<>();
    private Map<String, ArgsParser> schemaToArgsParser = new HashMap<>();

    public Args(String schema, String[] args) {
        this.schema = schema;
        this.args = args;
        this.parseArgs();
        this.parseSchema();
        this.configParser();
    }

    private void configParser() {
        this.schemaToArgsParser.put("", new BooleanArgsParser());
        this.schemaToArgsParser.put("*", new StringArgsParser());
        this.schemaToArgsParser.put("#", new IntegerArgsParser());
        this.schemaToArgsParser.put("##", new DoubleArgsParser());
    }

    private void parseSchema() {
        String[] schemaArr = this.schema.split(",");
        for (String str : schemaArr) {
            this.flagToSchemaMap.put(str.substring(0, 1), str.substring(1));
        }
    }

    public boolean hasFlag(String flag) {
        return Arrays.asList(args).indexOf("-" + flag) > -1;
    }

    public <T> T getValue(String flag) {
        if (!this.hasFlag(flag)) {
            throw new ArgsException("INVALID FLAG");
        }
        String schema = this.flagToSchemaMap.get(flag);
        String value = this.flagToValuesMap.get(flag);
        ArgsParser argsParser = this.schemaToArgsParser.get(schema);
        return (T) argsParser.parse(value);
    }


    private void parseArgs() {
        for (int index = 0, len = args.length; index < len; index++) {
            if (args[index].startsWith("-")) {
                String flag = args[index];
                String value = this.hasValue(index) ? args[index += 1] : null;
                this.flagToValuesMap.put(flag.substring(1), value);
            }
        }
    }

    private boolean hasValue(int index) {
        return index + 1 <= args.length - 1;
    }
}
