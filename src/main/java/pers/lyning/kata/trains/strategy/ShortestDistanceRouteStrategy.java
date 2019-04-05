package pers.lyning.kata.trains.strategy;

import pers.lyning.kata.trains.Digraph;
import pers.lyning.kata.trains.Route;

import java.util.List;
import java.util.Objects;

/**
 * 用于计算从起点到终点的路线的最短距离
 *
 * @author lyning
 */
public class ShortestDistanceRouteStrategy implements RouteStrategy {

    private Digraph digraph;
    private final Route route;
    private Integer shortestDistance;

    public ShortestDistanceRouteStrategy(Route route) {
        this.route = route;
    }

    @Override
    public Integer execute(Digraph digraph) {
        this.digraph = digraph;
        this.depthFirstSearch();
        return this.shortestDistance;
    }

    private void depthFirstSearch() {
        List<Route> routes = this.digraph.getRoutesOfOrigin(this.route.getOrigin());
        for (Route edge : routes) {
            this.depthFirstSearch(edge, edge.getName(), edge.getDistance());
        }
    }

    private void depthFirstSearch(Route currentRoute, String route, Integer distance) {
        // this.isInfiniteLoop(route) 用于打破循环，避免路线陷入无线循环
        if (!this.isShortest(distance) || this.isInfiniteLoop(route)) {
            return;
        }

        if (this.route.isEquals(route) && this.isShortest(distance)) {
            this.shortestDistance = distance;
            return;
        }

        List<Route> routes = this.digraph.getRoutesOfOrigin(currentRoute.getDestination());
        for (Route nextRoute : routes) {
            this.depthFirstSearch(nextRoute, route.concat(nextRoute.getDestination()), distance + nextRoute.getDistance());
        }
    }

    private boolean isInfiniteLoop(String route) {
        return route.length() > this.digraph.getRoutes().size();
    }

    public boolean isShortest(Integer distance) {
        if (Objects.isNull(this.shortestDistance) || distance < this.shortestDistance) {
            return true;
        }
        return false;
    }
}
