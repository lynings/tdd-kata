package pers.lyning.kata.trains.strategy;

/**
 * @author lyning
 */
public class StopsConstraint {
    private Integer numberOfStops;
    private ConditionEnum condition;

    public StopsConstraint(Integer numberOfStops, ConditionEnum condition) {
        this.numberOfStops = numberOfStops;
        this.condition = condition;
    }

    public Integer getNumberOfStops() {
        return numberOfStops;
    }

    public ConditionEnum getCondition() {
        return condition;
    }

    public boolean isValid(int currentStops) {
        return this.isEqual(currentStops) || this.isLessThanOrEqual(currentStops);
    }

    private boolean isLessThanOrEqual(int currentStops) {
        return this.getCondition() == ConditionEnum.LessThanOrEqual
                && currentStops <= this.getNumberOfStops();
    }

    private boolean isEqual(int currentStops) {
        return this.getCondition() == ConditionEnum.Equal
                && currentStops == this.getNumberOfStops();
    }
}
