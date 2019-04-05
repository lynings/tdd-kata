package pers.lyning.kata.trains.factory;

import pers.lyning.kata.trains.Route;
import pers.lyning.kata.trains.strategy.*;

/**
 * @author lyning
 */
public class RouteStrategyFactory {

    public static CalculationStrategy createSingleRouteDistanceCalculationStrategy(String route) {
        return new SingleRouteDistanceCalculationStrategy(route);
    }

    public static CalculationStrategy createStopsConstraintRoutesCalculationStrategy(Route route, RouteSpecification specification) {
        return new StopsConstraintRoutesCalculationStrategy(route, specification);
    }

    public static CalculationStrategy createDistanceConstraintRoutesCalculationStrategy(Route route, RouteSpecification specification) {
        return new DistanceConstraintRoutesCalculationStrategy(route, specification);
    }

    public static CalculationStrategy createShortestDistanceCalculationStrategy(Route route) {
        return new ShortestDistanceCalculationStrategy(route);
    }
}
