package pers.lyning.kata.trains;

import pers.lyning.kata.trains.factory.RouteStrategyFactory;
import pers.lyning.kata.trains.strategy.DistanceRouteStrategy;
import pers.lyning.kata.trains.strategy.RouteSpecification;
import pers.lyning.kata.trains.strategy.RouteStrategy;

import java.util.Arrays;
import java.util.List;

/**
 * @author lyning
 */
public class TrainMain {

    public static void main(String[] args) throws Exception {
        List<RouteStrategy> routeStrategies = Arrays.asList(
                RouteStrategyFactory.createDistanceRouteStrategy("ABC"),
                RouteStrategyFactory.createDistanceRouteStrategy("AD"),
                RouteStrategyFactory.createDistanceRouteStrategy("ADC"),
                RouteStrategyFactory.createDistanceRouteStrategy("AEBCD"),
                RouteStrategyFactory.createDistanceRouteStrategy("AED"),
                RouteStrategyFactory.createStopsConstraintRouteStrategy("C", "C", new RouteSpecification(3, RouteSpecification.ConstraintEnum.LessThanOrEqual)),
                RouteStrategyFactory.createStopsConstraintRouteStrategy("A", "C", new RouteSpecification(4, RouteSpecification.ConstraintEnum.Equal)),
                RouteStrategyFactory.createShortestDistanceRouteStrategy("A", "C"),
                RouteStrategyFactory.createShortestDistanceRouteStrategy("B", "B"),
                RouteStrategyFactory.createDistanceConstraintRouteStrategy("C", "C", new RouteSpecification(30, RouteSpecification.ConstraintEnum.LessThan))
        );

        List<Edge> edges = Arrays.asList(
                new Edge("A", "B", 5),
                new Edge("B", "C", 4),
                new Edge("C", "D", 8),
                new Edge("D", "C", 8),
                new Edge("D", "E", 6),
                new Edge("A", "D", 5),
                new Edge("C", "E", 2),
                new Edge("E", "B", 3),
                new Edge("A", "E", 7)
        );
        Digraph digraph = new Digraph(edges);

        for (int index = 1; index <= routeStrategies.size(); index++) {
            Integer result = digraph.calculate(routeStrategies.get(index - 1));
            if (index <= 5) {
                if (result.equals(DistanceRouteStrategy.NO_SUCH_ROUTE)) {
                    warning(index, "NO SUCH ROUTE");
                    continue;
                }
            }
            print(index, result);
        }
    }

    private static void print(Integer index, Integer result) {
        System.out.println(String.format("Output #%d: %d", index, result));
    }

    private static void warning(Integer index, String result) {
        System.out.println(String.format("Output #%d: %s", index, result));
    }
}
