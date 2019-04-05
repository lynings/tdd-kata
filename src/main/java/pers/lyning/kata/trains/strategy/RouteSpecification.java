package pers.lyning.kata.trains.strategy;

/**
 * @author lyning
 */
public class RouteSpecification {

    private Integer value;

    private ConstraintEnum constraint;

    public RouteSpecification(Integer value, ConstraintEnum constraint) {
        this.value = value;
        this.constraint = constraint;
    }

    public Integer getValue() {
        return value;
    }

    public boolean isValid(Integer value) {
        return this.isEqual(value)
                || this.isLessThan(value)
                || this.isLessThanOrEqual(value);
    }

    private boolean isLessThan(Integer value) {
        return this.constraint == ConstraintEnum.LessThan && value < this.getValue();
    }

    private boolean isLessThanOrEqual(Integer value) {
        return this.constraint == ConstraintEnum.LessThanOrEqual
                && value <= this.getValue();
    }

    private boolean isEqual(int value) {
        return this.constraint == ConstraintEnum.Equal
                && value == this.getValue();
    }

    public enum ConstraintEnum {
        None,
        Equal,
        LessThan,
        LessThanOrEqual
    }
}
