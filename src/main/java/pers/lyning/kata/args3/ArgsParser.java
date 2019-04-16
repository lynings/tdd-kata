package pers.lyning.kata.args3;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author lyning
 */
public class ArgsParser {

    private final Args args;
    private final Schema schema;

    public ArgsParser(String schema, String[] args) {
        this.schema = Schema.parse(schema);
        this.args = Args.parse(args);
    }

    public <T> T getValue(String flag) {
        String value = this.args.getValue(flag);
        String schema = this.schema.get(flag);
        switch (schema) {
            case "":
                return (T) this.getBoolean(value);
            case "*":
                return (T) this.getString(value);
            case "#":
                return (T) this.getInteger(value);
            case "[*]":
                return (T) this.getStringArray(value);
            case "[#]":
                return (T) this.getIntegerArray(value);
            default:
                throw new ArgsException("schema not found.");
        }
    }

    private Integer[] getIntegerArray(String value) {
        try {
            return Optional
                    .ofNullable(value)
                    .map(s -> s.split(" "))
                    .map(ArgsParser::toIntegerArr)
                    .orElse(new Integer[]{});
        } catch (Exception e) {
            throw new ArgsException("value should be int type.");
        }
    }

    private static Integer[] toIntegerArr(String[] arr) {
        return Arrays.asList(arr)
                .stream()
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }


    private String[] getStringArray(String value) {
        return Optional
                .ofNullable(value)
                .map(s -> s.split(" "))
                .orElse(new String[]{});
    }

    private Integer getInteger(String value) {
        try {
            return Optional
                    .ofNullable(value)
                    .map(Integer::valueOf)
                    .orElse(0);
        } catch (Exception e) {
            throw new ArgsException("value should be int type.");
        }
    }

    private String getString(String value) {
        return Optional
                .ofNullable(value)
                .orElse("");
    }

    private Boolean getBoolean(String value) {
        return Optional
                .ofNullable(value)
                .map((a) -> true)
                .orElse(false);
    }
}
