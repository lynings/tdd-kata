package pers.lyning.kata.trains;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lyning
 */
public class PointToPointStopsConstraintRouteStrategy implements RouteStrategy {

    private Digraph digraph;
    private final Route route;
    private final StopsConstraint stopsConstraint;

    public PointToPointStopsConstraintRouteStrategy(Route route, StopsConstraint stopsConstraint) {
        this.route = route;
        this.stopsConstraint = stopsConstraint;
    }

    @Override
    public Integer calculate(Digraph digraph) {
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

    private void depthFirstSearch(Edge origin, String route, Set<String> routes) {
        // 打破循环，避免路线陷入无线循环
        if (this.isInfiniteLoop(origin.getName(), route)) {
            return;
        }

        if (this.route.isArrivedToDestination(route) && this.stopsConstraint.isValid(route.length() - 1)) {
            routes.add(route);
            return;
        }

        List<Edge> edgeList = this.digraph.getEdgesOfOrigin(origin.getEndNode());
        for (Edge edge : edgeList) {
            this.depthFirstSearch(edge, route + edge.getEndNode(), routes);
        }
    }

    private boolean isInfiniteLoop(String edge, String route) {
        return (route.length() - route.split(edge).length) / 2 > this.stopsConstraint.getNumberOfStops();
    }
}

