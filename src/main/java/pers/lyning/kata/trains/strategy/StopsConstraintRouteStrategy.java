package pers.lyning.kata.trains.strategy;

import pers.lyning.kata.trains.Digraph;
import pers.lyning.kata.trains.Route;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用于计算从起点到终点的所有可行路线，不过路线收到途径站数量的限制
 *
 * @author lyning
 */
public class StopsConstraintRouteStrategy implements RouteStrategy {

    private Digraph digraph;
    private final Route route;
    private final RouteSpecification routeSpecification;

    public StopsConstraintRouteStrategy(Route route, RouteSpecification routeSpecification) {
        this.route = route;
        this.routeSpecification = routeSpecification;
    }

    @Override
    public Integer execute(Digraph digraph) {
        this.digraph = digraph;
        Set<String> routes = this.getRoutes();
        return routes.size();
    }

    private Set<String> getRoutes() {
        Set<String> routeSet = new HashSet<>();

        List<Route> routes = this.digraph.getRoutesOfOrigin(this.route.getOrigin());
        for (Route route : routes) {
            this.depthFirstSearch(route, route.getName(), routeSet);
        }
        return routeSet;
    }

    private void depthFirstSearch(Route currentRoute, String route, Set<String> routeSet) {
        // 用于打破循环，避免路线陷入无线循环
        if (this.isInfiniteLoop(route)) {
            return;
        }

        if (this.route.isEquals(route) && this.routeSpecification.isValid(route.length() - 1)) {
            routeSet.add(route);
            return;
        }

        List<Route> routes = this.digraph.getRoutesOfOrigin(currentRoute.getDestination());
        for (Route nextRoute : routes) {
            this.depthFirstSearch(nextRoute, route + nextRoute.getDestination(), routeSet);
        }
    }

    private boolean isInfiniteLoop(String route) {
        return route.length() > this.digraph.getRoutes().size();
    }
}