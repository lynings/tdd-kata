package pers.lyning.kata.args5;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * @author lyning
 */
public class ArgsParser {
    private final Args args;
    private final Schema schema;

    public ArgsParser(String schemas, String[] args) {
        this.schema = Schema.parse(schemas);
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
                return (T) this.getInt(value);
            case "[#]":
                return (T) this.getIntArray(value);
            case "[*]":
                return (T) this.getStringArray(value);
            default:
                throw new ArgsException("schema not found.");
        }
    }

    private String[] getStringArray(String value) {
        return Optional
                .ofNullable(value)
                .map(s -> s.split(" "))
                .orElse(new String[]{});
    }

    private Integer[] getIntArray(String value) {
        if (Objects.isNull(value)) {
            return new Integer[]{};
        }
        try {
            return Arrays.asList(value.split(" "))
                    .stream()
                    .map(Integer::valueOf)
                    .toArray(Integer[]::new);
        } catch (Exception e) {
            throw new ArgsException("value should be an int type.");
        }
    }

    private Integer getInt(String value) {
        try {
            return Optional
                    .ofNullable(value)
                    .map(Integer::valueOf)
                    .orElse(0);
        } catch (Exception e) {
            throw new ArgsException("value should be an int type.");
        }
    }

    private String getString(String value) {
        return Objects.isNull(value) ? "" : value;
    }

    private Boolean getBoolean(String value) {
        return Objects.isNull(value) ? false : true;
    }
}
