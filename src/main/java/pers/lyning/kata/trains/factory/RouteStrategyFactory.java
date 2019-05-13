package pers.lyning.kata.trains.factory;

import pers.lyning.kata.trains.Route;
import pers.lyning.kata.trains.strategy.*;

/**
 * @author lyning
 */
public class RouteStrategyFactory {

    public static RouteStrategy createDistanceConstraintRouteStrategy(String origin, String destination, RouteSpecification specification) {
        return new DistanceConstraintRouteStrategy(new Route(origin, destination), specification);
    }

    public static RouteStrategy createDistanceRouteStrategy(String route) {
        return new DistanceRouteStrategy(route);
    }

    public static RouteStrategy createShortestDistanceRouteStrategy(String origin, String destination) {
        return new ShortestDistanceRouteStrategy(new Route(origin, destination));
    }

    public static RouteStrategy createStopsConstraintRouteStrategy(String origin, String destination, RouteSpecification specification) {
        return new StopsConstraintRouteStrategy(new Route(origin, destination), specification);
    }
}
