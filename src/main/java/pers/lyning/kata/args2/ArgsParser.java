package pers.lyning.kata.args2;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author lyning
 */
public class ArgsParser {
    private final Schema schema;
    private final Args args;

    public ArgsParser(String schema, String[] args) {
        this.schema = Schema.parse(schema);
        this.args = Args.parse(args);
    }


    public boolean hasFlag(String flag) {
        return this.args.containsFlag(flag);
    }

    public <T> T getValue(String flag) {
        String schema = this.schema.get(flag);
        switch (schema) {
            case "":
                return (T) this.getBoolean(flag);
            case "#":
                return (T) this.getInt(flag);
            case "*":
                return (T) this.getString(flag);
            case "[*]":
                return (T) this.getStringArray(flag);
            case "[#]":
                return (T) this.getIntegerArray(flag);
            default:
                throw new ArgsException("INVALID SCHEMA.");
        }
    }

    private String[] getStringArray(String flag) {
        return Optional
                .ofNullable(this.args.getValue(flag))
                .map(value -> value.split(" "))
                .orElse(new String[]{});
    }

    private Integer[] getIntegerArray(String flag) {
        return Optional
                .ofNullable(this.args.getValue(flag))
                .map(value -> value.split(" "))
                .map(ArgsParser::toIntArr)
                .orElse(new Integer[]{});
    }

    private static Integer[] toIntArr(String[] arr) {
        return Arrays
                .asList(arr)
                .stream()
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }

    private Integer getInt(String flag) {
        return Optional
                .ofNullable(this.args.getValue(flag))
                .map(Integer::valueOf)
                .orElse(0);
    }

    private String getString(String flag) {
        return Optional
                .ofNullable(this.args.getValue(flag))
                .orElse("");
    }

    private Boolean getBoolean(String flag) {
        return Optional
                .ofNullable(this.args.getValue(flag))
                .map((b) -> true)
                .orElse(false);
    }
}
