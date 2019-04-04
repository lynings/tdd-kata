package pers.lyning.kata.trains;

/**
 * @author lyning
 */
public class RouteStrategyFactory {

    public static RouteStrategy createPointToPointDistanceRouteStrategy(String route) {
        return new PointToPointDistanceRouteStrategy(route);
    }

    public static RouteStrategy createPointToPointStopsConstraintRouteStrategy(Route route, int limitOfStops, ConditionEnum conditionEnum) {
        return new PointToPointStopsConstraintRouteStrategy(route, new StopsConstraint(limitOfStops, conditionEnum));
    }

    public static RouteStrategy createPointToPointDistanceConstraintRouteStrategy(Route route, int distance, ConditionEnum conditionEnum) {
        return new PointToPointDistanceConstraintRouteStrategy(route, new DistanceConstraint(distance, conditionEnum));
    }

    public static RouteStrategy createPointToPointShortestRouteStrategy(Route route) {
        return new PointToPointShortestRouteStrategy(route);
    }
}
