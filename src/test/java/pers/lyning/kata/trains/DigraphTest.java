package pers.lyning.kata.trains;

import org.junit.Test;

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
        List<ResultAndRouteStrategy> distanceAndRouteStrategyList = Arrays.asList(
                new ResultAndRouteStrategy(9, RouteStrategyFactory.createPointToPointDistanceRouteStrategy(edges, "ABC")),
                new ResultAndRouteStrategy(5, RouteStrategyFactory.createPointToPointDistanceRouteStrategy(edges, "AD")),
                new ResultAndRouteStrategy(13, RouteStrategyFactory.createPointToPointDistanceRouteStrategy(edges, "ADC")),
                new ResultAndRouteStrategy(22, RouteStrategyFactory.createPointToPointDistanceRouteStrategy(edges, "AEBCD"))
        );
        for (ResultAndRouteStrategy obj : distanceAndRouteStrategyList) {
            assertThat(digraph.calculate(obj.getRouteStrategy())).isEqualTo(obj.getResult());
        }
    }

    @Test
    public void should_return_times_of_routes_when_calculate_all_routes_from_origin_to_destination() throws Exception {
        List<ResultAndRouteStrategy> strategies = Arrays.asList(
                new ResultAndRouteStrategy(2, RouteStrategyFactory.createPointToPointStopsConstraintRouteStrategy(edges, "CC", 3, ConditionEnum.LessThanOrEqual)),
                new ResultAndRouteStrategy(3, RouteStrategyFactory.createPointToPointStopsConstraintRouteStrategy(edges, "AC", 4, ConditionEnum.Equal))
        );

        for (ResultAndRouteStrategy resultAndRouteStrategy : strategies) {
            Integer timesOfRoutes = this.digraph.calculate(resultAndRouteStrategy.getRouteStrategy());
            assertThat(timesOfRoutes).isEqualTo(resultAndRouteStrategy.getResult());
        }
    }

    @Test
    public void should_return_7_when_calculate_all_the_routes_of_c_to_c() throws Exception {
        String route = "CC";
        final int MAX_DISTANCE = 30;
        ConditionEnum conditionEnum = ConditionEnum.LessThan;
        RouteStrategy strategy = RouteStrategyFactory.createPointToPointDistanceConstraintRouteStrategy(edges, route, MAX_DISTANCE, conditionEnum);
        Integer times = this.digraph.calculate(strategy);
        assertThat(times).isEqualTo(7);
    }

    @Test
    public void should_return_distance_when_calculate_the_shortest_route_distance_of_origin_to_destination() throws Exception {
        List<ResultAndRouteStrategy> distanceAndRouteStrategyList = Arrays.asList(
                new ResultAndRouteStrategy(9, RouteStrategyFactory.createPointToPointShortestRouteStrategy(edges, "AC")),
                new ResultAndRouteStrategy(9, RouteStrategyFactory.createPointToPointShortestRouteStrategy(edges, "BB"))
        );
        for (ResultAndRouteStrategy obj : distanceAndRouteStrategyList) {
            assertThat(obj.getResult()).isEqualTo(9);
        }
    }

    private static class ResultAndRouteStrategy {
        private Integer result;
        private RouteStrategy routeStrategy;

        public ResultAndRouteStrategy(Integer result, RouteStrategy routeStrategy) {
            this.result = result;
            this.routeStrategy = routeStrategy;
        }

        public Integer getResult() {
            return result;
        }

        public RouteStrategy getRouteStrategy() {
            return routeStrategy;
        }
    }
}