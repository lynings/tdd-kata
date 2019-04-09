package pers.lyning.kata.trains.strategy;

import pers.lyning.kata.trains.Digraph;
import pers.lyning.kata.trains.Route;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用于计算从起点到终点的所有可行路线，不过路线收到距离长短的限制
 *
 * @author lyning
 */
public class DistanceConstraintRouteStrategy implements RouteStrategy {

    private Digraph digraph;
    private final Route route;
    private final Set<String> routes;
    private final RouteSpecification routeSpecification;

    public DistanceConstraintRouteStrategy(Route route, RouteSpecification routeSpecification) {
        this.route = route;
        this.routeSpecification = routeSpecification;
        routes = new HashSet<>();
    }

    @Override
    public Integer execute(Digraph digraph) {
        this.digraph = digraph;
        this.depthFirstSearch();
        return routes.size();
    }

    private void depthFirstSearch() {
        List<Route> routes = this.digraph.selectRouteWithOrigin(route.getOrigin());
        for (Route route : routes) {
            this.depthFirstSearch(route, route.getName(), route.getDistance());
        }
    }

    private void depthFirstSearch(Route currentRoute, String route, Integer distance) {
        if (!this.routeSpecification.isValid(distance)) {
            return;
        }

        if (this.route.isEquals(route) && this.routeSpecification.isValid(distance)) {
            routes.add(route);
        }

        List<Route> routes = this.digraph.selectRouteWithOrigin(currentRoute.getDestination());
        for (Route nextRoute : routes) {
            this.depthFirstSearch(nextRoute, route.concat(nextRoute.getDestination()), distance + nextRoute.getDistance());
        }
    }
}

