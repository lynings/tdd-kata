package pers.lyning.kata.trains.factory;

import pers.lyning.kata.trains.Route;
import pers.lyning.kata.trains.strategy.*;

/**
 * @author lyning
 */
public class RouteStrategyFactory {

    public static Strategy createPointToPointDistanceRouteStrategy(String route) {
        return new CalculationSingleRouteDistanceStrategy(route);
    }

    public static Strategy createPointToPointStopsConstraintRouteStrategy(Route route, RouteSpecification specification) {
        return new CalculationStopsConstraintRoutesStrategy(route, specification);
    }

    public static Strategy createPointToPointDistanceConstraintRouteStrategy(Route route, RouteSpecification specification) {
        return new CalculationDistanceConstraintRoutesStrategy(route, specification);
    }

    public static Strategy createPointToPointShortestRouteStrategy(Route route) {
        return new CalculationShortestDistanceStrategy(route);
    }
}
