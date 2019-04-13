package pers.lyning.kata.args2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lyning
 */
public class Args {
    private final ArgsParser argsParser;
    private final SchemaParser schemaParser;
    private Map<String, ValueParser> schemaToValueParser = new HashMap<>();

    public Args(String schema, String[] args) {
        this.argsParser = new ArgsParser(args);
        this.schemaParser = new SchemaParser(schema);
        List<String> schemas = this.schemaParser.getSchemas();
        this.configValuesParsers(schemas);
    }

    private void configValuesParsers(List<String> schemas) {
        for (String schema : schemas) {
            switch (schema) {
                case "":
                    this.schemaToValueParser.put("", new BooleanValueParser());
                    break;
                case "*":
                    this.schemaToValueParser.put("*", new StringValueParser());
                    break;
                case "#":
                    this.schemaToValueParser.put("#", new IntegerValueParser());
                    break;
                case "##":
                    this.schemaToValueParser.put("##", new DoubleValueParser());
                    break;
                case "[*]":
                    this.schemaToValueParser.put("[*]", new StringArraysValueParser());
                    break;
                case "[#]":
                    this.schemaToValueParser.put("[#]", new IntegerArraysValueParser());
                    break;
                case "[##]":
                    this.schemaToValueParser.put("[##]", new DoubleArraysValueParser());
                    break;
                case "[&]":
                    this.schemaToValueParser.put("[&]", new SetValueParser());
                    break;
                case "[&&]":
                    this.schemaToValueParser.put("[&&]", new MapValueParser());
                    break;
                default:
                    throw new ArgsException("SCHEMA NOT IMPLEMENTED");
            }
        }
    }

    public <T> T getValue(String flag) {
        if (!this.hasFlag(flag)) {
            throw new ArgsException("INVALID FLAG");
        }
        ValueParser valueParser = this.getValueParser(flag);
        String value = this.argsParser.getValue(flag);
        return (T) valueParser.parse(value);
    }

    public boolean hasFlag(String flag) {
        return this.argsParser.hasFlag(flag);
    }

    private ValueParser getValueParser(String flag) {
        String schema = this.schemaParser.getSchema(flag);
        ValueParser valueParser = this.schemaToValueParser.get(schema);
        return valueParser;
    }
}
