package pers.lyning.kata.trains;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pers.lyning.kata.trains.factory.RouteStrategyFactory;
import pers.lyning.kata.trains.strategy.DistanceRouteStrategy;
import pers.lyning.kata.trains.strategy.RouteSpecification;
import pers.lyning.kata.trains.strategy.RouteStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class DigraphTest {

    @Rule
    public final ExpectedException expectedEx = ExpectedException.none();

    private final List<Route> routes = Arrays.asList(
            new Route("A", "B", 5),
            new Route("B", "C", 4),
            new Route("C", "D", 8),
            new Route("D", "C", 8),
            new Route("D", "E", 6),
            new Route("A", "D", 5),
            new Route("C", "E", 2),
            new Route("E", "B", 3),
            new Route("A", "E", 7)
    );
    private final Digraph digraph = new Digraph(routes);

    @Test
    public void should_return_distance_when_calculate_the_distance_of_route() throws Exception {
        List<ResultAndStrategy> distanceAndStrategyList = Arrays.asList(
                new ResultAndStrategy(9, RouteStrategyFactory.createDistanceRouteStrategy("ABC")),
                new ResultAndStrategy(5, RouteStrategyFactory.createDistanceRouteStrategy("AD")),
                new ResultAndStrategy(13, RouteStrategyFactory.createDistanceRouteStrategy("ADC")),
                new ResultAndStrategy(22, RouteStrategyFactory.createDistanceRouteStrategy("AEBCD"))
        );
        for (ResultAndStrategy resultAndStrategy : distanceAndStrategyList) {
            Integer distance = digraph.calculate(resultAndStrategy.getRouteRouteStrategy());
            assertThat(distance).isEqualTo(resultAndStrategy.getResult());
        }
    }

    @Test
    public void should_return_negative_1_when_no_such_route() throws Exception {
        RouteStrategy routeStrategy = RouteStrategyFactory.createDistanceRouteStrategy("AED");
        Integer distance = this.digraph.calculate(routeStrategy);
        assertThat(distance).isEqualTo(DistanceRouteStrategy.NO_SUCH_ROUTE);
    }

    @Test
    public void should_return_number_of_routes_when_calculate_all_routes_from_origin_to_destination() throws Exception {
        List<ResultAndStrategy> strategies = Arrays.asList(
                new ResultAndStrategy(2, RouteStrategyFactory.createStopsConstraintRouteStrategy("C", "C", new RouteSpecification(3, RouteSpecification.ConstraintEnum.LessThanOrEqual))),
                new ResultAndStrategy(3, RouteStrategyFactory.createStopsConstraintRouteStrategy("A", "C", new RouteSpecification(4, RouteSpecification.ConstraintEnum.Equal)))
        );

        for (ResultAndStrategy resultAndStrategy : strategies) {
            Integer timesOfRoutes = this.digraph.calculate(resultAndStrategy.getRouteRouteStrategy());
            assertThat(timesOfRoutes).isEqualTo(resultAndStrategy.getResult());
        }
    }

    @Test
    public void should_return_7_when_calculate_all_the_routes_of_C_to_C() throws Exception {
        final int MAX_DISTANCE = 30;
        RouteSpecification routeSpecification = new RouteSpecification(MAX_DISTANCE, RouteSpecification.ConstraintEnum.LessThan);
        RouteStrategy routeStrategy = RouteStrategyFactory.createDistanceConstraintRouteStrategy("C", "C", routeSpecification);
        Integer times = this.digraph.calculate(routeStrategy);
        assertThat(times).isEqualTo(7);
    }

    @Test
    public void should_return_shortest_distance_when_calculate_the_route_from_origin_to_destination() throws Exception {
        List<ResultAndStrategy> distanceAndStrategyList = Arrays.asList(
                new ResultAndStrategy(9, RouteStrategyFactory.createShortestDistanceRouteStrategy("A", "C")),
                new ResultAndStrategy(9, RouteStrategyFactory.createShortestDistanceRouteStrategy("B", "B"))
        );
        for (ResultAndStrategy obj : distanceAndStrategyList) {
            assertThat(obj.getResult()).isEqualTo(9);
        }
    }

    @Test
    public void should_fail_when_route_more_than_once() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("duplicated route!");

        Digraph digraph = new Digraph(Arrays.asList(
                new Route("A", "B", 5),
                new Route("B", "C", 4),
                new Route("A", "B", 5)
        ));
        RouteStrategy routeStrategy = RouteStrategyFactory.createDistanceRouteStrategy("ABC");
        digraph.calculate(routeStrategy);
    }

    @Test
    public void should_fail_when_the_origin_and_destination_of_the_route_are_the_same() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("origin and destination cannot be the same!");

        Digraph digraph = new Digraph(Arrays.asList(
                new Route("A", "B", 5),
                new Route("B", "C", 4),
                new Route("D", "D", 2)
        ));
        RouteStrategy routeStrategy = RouteStrategyFactory.createDistanceRouteStrategy("ABC");
        digraph.calculate(routeStrategy);
    }

    private class ResultAndStrategy {
        private Integer result;
        private RouteStrategy routeRouteStrategy;

        public ResultAndStrategy(Integer result, RouteStrategy routeRouteStrategy) {
            this.result = result;
            this.routeRouteStrategy = routeRouteStrategy;
        }

        public Integer getResult() {
            return result;
        }

        public RouteStrategy getRouteRouteStrategy() {
            return routeRouteStrategy;
        }
    }
}