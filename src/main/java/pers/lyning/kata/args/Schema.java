package pers.lyning.kata.args;

/**
 * @author lyning
 */
class Schema {
    private final String value;

    public Schema(String value) {
        this.value = value;
    }

    public Character flag() {
        return value.substring(0, 1).charAt(0);
    }

    public String name() {
        return value.substring(1);
    }
}
