package pers.lyning.kata.trains;

/**
 * @author lyning
 */
public class DistanceConstraint {
    private Integer distance;
    private ConditionEnum condition;

    public DistanceConstraint(Integer distance, ConditionEnum condition) {
        this.distance = distance;
        this.condition = condition;
    }

    public Integer getDistance() {
        return distance;
    }

    public ConditionEnum getCondition() {
        return condition;
    }

    public boolean isValid(Integer distance) {
        return this.isLessThan(distance);
    }

    private boolean isLessThan(Integer distance) {
        return this.getCondition() == ConditionEnum.LessThan && distance < this.getDistance();
    }
}
