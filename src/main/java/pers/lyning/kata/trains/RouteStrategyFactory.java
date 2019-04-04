package pers.lyning.kata.trains;

/**
 * @author lyning
 */
public class RouteStrategyFactory {

    public static RouteStrategy createPointToPointDistanceRouteStrategy(Digraph digraph, String route) {
        return new PointToPointDistanceRouteStrategy(digraph, route);
    }

    public static RouteStrategy createPointToPointStopsConstraintRouteStrategy(Digraph digraph, String route, int limitOfStops, ConditionEnum conditionEnum) {
        return new PointToPointStopsConstraintRouteStrategy(digraph, route, new StopsConstraint(limitOfStops, conditionEnum));
    }

    public static RouteStrategy createPointToPointDistanceConstraintRouteStrategy(Digraph digraph, String route, int distance, ConditionEnum conditionEnum) {
        return new PointToPointDistanceConstraintRouteStrategy(digraph, route, new DistanceConstraint(distance, conditionEnum));
    }

    public static RouteStrategy createPointToPointShortestRouteStrategy(Digraph digraph, String route) {
        return new PointToPointShortestRouteStrategy(digraph, route);
    }
}
