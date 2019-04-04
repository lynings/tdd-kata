package pers.lyning.kata.trains;

import java.util.List;

/**
 * @author lyning
 */
public class RouteStrategyFactory {

    public static RouteStrategy createPointToPointDistanceRouteStrategy(List<Edge> edges, String route) {
        return new PointToPointDistanceRouteStrategy(edges, route);
    }

    public static RouteStrategy createPointToPointStopsConstraintRouteStrategy(List<Edge> edges, String route, int limitOfStops, ConditionEnum conditionEnum) {
        return new PointToPointStopsConstraintRouteStrategy(edges, route, new StopsConstraint(limitOfStops, conditionEnum));
    }

    public static RouteStrategy createPointToPointDistanceConstraintRouteStrategy(List<Edge> edges, String route, int distance, ConditionEnum conditionEnum) {
        return new PointToPointDistanceConstraintRouteStrategy(edges, route, new DistanceConstraint(distance, conditionEnum));
    }

    public static RouteStrategy createPointToPointShortestRouteStrategy(List<Edge> edges, String route) {
        return new PointToPointShortestRouteStrategy(edges, route);
    }
}
