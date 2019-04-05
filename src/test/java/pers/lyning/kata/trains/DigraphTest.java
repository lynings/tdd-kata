package pers.lyning.kata.trains;

import org.junit.Test;
import pers.lyning.kata.trains.factory.RouteStrategyFactory;
import pers.lyning.kata.trains.strategy.CalculationStrategy;
import pers.lyning.kata.trains.strategy.RouteSpecification;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class DigraphTest {

    private final List<Edge> edges = Arrays.asList(
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
    private final Digraph digraph = new Digraph(edges);

    @Test
    public void should_return_distance_when_calculate_the_distance_of_route() throws Exception {
        List<ResultAndStrategy> distanceAndRouteStrategyList = Arrays.asList(
                new ResultAndStrategy(9, RouteStrategyFactory.createSingleRouteDistanceCalculationStrategy("ABC")),
                new ResultAndStrategy(5, RouteStrategyFactory.createSingleRouteDistanceCalculationStrategy("AD")),
                new ResultAndStrategy(13, RouteStrategyFactory.createSingleRouteDistanceCalculationStrategy("ADC")),
                new ResultAndStrategy(22, RouteStrategyFactory.createSingleRouteDistanceCalculationStrategy("AEBCD"))
        );
        for (ResultAndStrategy obj : distanceAndRouteStrategyList) {
            assertThat(digraph.calculate(obj.getRouteCalculationStrategy())).isEqualTo(obj.getResult());
        }
    }

    @Test
    public void should_return_times_of_routes_when_calculate_all_routes_from_origin_to_destination() throws Exception {
        List<ResultAndStrategy> strategies = Arrays.asList(
                new ResultAndStrategy(2, RouteStrategyFactory.createStopsConstraintRoutesCalculationStrategy(new Route("C", "C"), new RouteSpecification(3, RouteSpecification.ConstraintEnum.LessThanOrEqual))),
                new ResultAndStrategy(3, RouteStrategyFactory.createStopsConstraintRoutesCalculationStrategy(new Route("A", "C"), new RouteSpecification(4, RouteSpecification.ConstraintEnum.Equal)))
        );

        for (ResultAndStrategy resultAndRouteStrategy : strategies) {
            Integer timesOfRoutes = this.digraph.calculate(resultAndRouteStrategy.getRouteCalculationStrategy());
            assertThat(timesOfRoutes).isEqualTo(resultAndRouteStrategy.getResult());
        }
    }

    @Test
    public void should_return_7_when_calculate_all_the_routes_of_c_to_c() throws Exception {
        Route route = new Route("C", "C");
        final int MAX_DISTANCE = 30;
        RouteSpecification routeSpecification = new RouteSpecification(MAX_DISTANCE, RouteSpecification.ConstraintEnum.LessThan);
        CalculationStrategy calculationStrategy = RouteStrategyFactory.createDistanceConstraintRoutesCalculationStrategy(route, routeSpecification);
        Integer times = this.digraph.calculate(calculationStrategy);
        assertThat(times).isEqualTo(7);
    }

    @Test
    public void should_return_shortest_distance_when_calculate_the_routes_from_origin_to_destination() throws Exception {
        List<ResultAndStrategy> distanceAndStrategyList = Arrays.asList(
                new ResultAndStrategy(9, RouteStrategyFactory.createShortestDistanceCalculationStrategy(new Route("A", "C"))),
                new ResultAndStrategy(9, RouteStrategyFactory.createShortestDistanceCalculationStrategy(new Route("B", "B")))
        );
        for (ResultAndStrategy obj : distanceAndStrategyList) {
            assertThat(obj.getResult()).isEqualTo(9);
        }
    }

    private static class ResultAndStrategy {
        private Integer result;
        private CalculationStrategy routeCalculationStrategy;

        public ResultAndStrategy(Integer result, CalculationStrategy routeCalculationStrategy) {
            this.result = result;
            this.routeCalculationStrategy = routeCalculationStrategy;
        }

        public Integer getResult() {
            return result;
        }

        public CalculationStrategy getRouteCalculationStrategy() {
            return routeCalculationStrategy;
        }
    }
}