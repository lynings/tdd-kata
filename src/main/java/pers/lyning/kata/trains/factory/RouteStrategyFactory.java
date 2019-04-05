package pers.lyning.kata.trains.factory;

import pers.lyning.kata.trains.Route;
import pers.lyning.kata.trains.strategy.*;

/**
 * @author lyning
 */
public class RouteStrategyFactory {

    public static RouteStrategy createDistanceRouteStrategy(String route) {
        return new DistanceRouteStrategy(route);
    }

    public static RouteStrategy createStopsConstraintRouteStrategy(Route route, RouteSpecification specification) {
        return new StopsConstraintRouteStrategy(route, specification);
    }

    public static RouteStrategy createDistanceConstraintRouteStrategy(Route route, RouteSpecification specification) {
        return new DistanceConstraintRouteStrategy(route, specification);
    }

    public static RouteStrategy createShortestDistanceRouteStrategy(Route route) {
        return new ShortestDistanceRouteStrategy(route);
    }
}
