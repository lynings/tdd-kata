package pers.lyning.kata.trains;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * @author lyning
 */
public class PointToPointStopsConstraintRouteStrategy implements RouteStrategy {

    private List<Edge> edges;
    private String origin;
    private String destination;
    private StopsConstraint stopsConstraint;

    public PointToPointStopsConstraintRouteStrategy(List<Edge> edges, String route, StopsConstraint stopsConstraint) {
        this.edges = edges;
        this.origin = route.split("")[0];
        this.destination = route.split("")[1];
        this.stopsConstraint = stopsConstraint;
    }

    @Override
    public Integer calculate() {
        Set<String> routes = this.getRoutes();
        return routes.size();
    }

    private Set<String> getRoutes() {
        Set<String> routes = new HashSet<>();

        List<Edge> edgeList = this.getEdgesWithOrigin(this.origin);
        for (Edge edge : edgeList) {
            this.includeRoutesAndSearch(edge, edge.getOrigin() + edge.getDestination(), routes);
        }
        return routes;
    }

    private void includeRoutesAndSearch(Edge origin, String route, Set<String> routes) {
        // 打破循环，避免路线陷入无线循环
        if (this.isInfiniteLoop(origin.getOrigin() + origin.getDestination(), route)) {
            return;
        }

        if (this.isArrivedToDestination(route) && this.stopsConstraint.isValid(route.length() - 1)) {
            routes.add(route);
            return;
        }

        List<Edge> edgeList = this.getEdgesWithOrigin(origin.getDestination());
        for (Edge edge : edgeList) {
            this.includeRoutesAndSearch(edge, route + edge.getDestination(), routes);
        }
    }

    private boolean isInfiniteLoop(String edge, String route) {
        return (route.length() - route.split(edge).length) / 2 > this.stopsConstraint.getNumberOfStops();
    }

    private boolean isArrivedToDestination(String route) {
        if (route.startsWith(this.origin) && route.endsWith(this.destination)) {
            return true;
        }
        return false;
    }

    private List<Edge> getEdgesWithOrigin(String origin) {
        return this.edges
                .stream()
                .filter(o -> o.getOrigin().equals(origin))
                .collect(toList());
    }
}

