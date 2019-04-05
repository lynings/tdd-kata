package pers.lyning.kata.trains.strategy;

import pers.lyning.kata.trains.Digraph;
import pers.lyning.kata.trains.Edge;
import pers.lyning.kata.trains.Route;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lyning
 */
public class StopsConstraintRoutesCalculationStrategy implements CalculationStrategy {

    private Digraph digraph;
    private final Route route;
    private final RouteSpecification routeSpecification;

    public StopsConstraintRoutesCalculationStrategy(Route route, RouteSpecification routeSpecification) {
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
        Set<String> routes = new HashSet<>();

        List<Edge> edges = this.digraph.getEdgesOfOrigin(this.route.getOrigin());
        for (Edge edge : edges) {
            this.depthFirstSearch(edge, edge.getName(), routes);
        }
        return routes;
    }

    private void depthFirstSearch(Edge partOfRoute, String route, Set<String> routes) {
        // 用于打破循环，避免路线陷入无线循环
        if (this.isInfiniteLoop(route)) {
            return;
        }

        if (this.route.isEquals(route) && this.routeSpecification.isValid(route.length() - 1)) {
            routes.add(route);
            return;
        }

        List<Edge> edges = this.digraph.getEdgesOfOrigin(partOfRoute.getEndNode());
        for (Edge edge : edges) {
            this.depthFirstSearch(edge, route + edge.getEndNode(), routes);
        }
    }

    private boolean isInfiniteLoop(String route) {
        return route.length() > this.digraph.getEdges().size();
    }
}