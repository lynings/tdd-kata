package pers.lyning.kata.trains;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

/**
 * @author lyning
 */
public class PointToPointShortestRouteStrategy implements RouteStrategy {

    private List<Edge> edges;
    private String origin;
    private String destination;
    private final Integer MAX_NUMBER_OF_STOP_STATION = 10;

    public PointToPointShortestRouteStrategy(List<Edge> edges, String route) {
        this.edges = edges;
        this.origin = route.split("")[0];
        this.destination = route.split("")[1];
    }

    @Override
    public Integer calculate() {
        RouteCollector routeCollector = this.getShortestDistance();
        return routeCollector.getDistance();
    }

    private RouteCollector getShortestDistance() {
        return this.depthFirstSearch();
    }

    private RouteCollector depthFirstSearch() {
        RouteCollector routeCollector = new RouteCollector();
        List<Edge> edges = this.getEdgesOfOrigin(this.origin);
        for (Edge edge : edges) {
            String route = edge.getOrigin() + edge.getDestination();
            this.depthFirstSearch(edge, route, edge.getDistance(), routeCollector);
        }
        return routeCollector;
    }

    private void depthFirstSearch(Edge partOfRoute, String route, Integer distance, RouteCollector routeCollector) {
        if (!this.isDecreased(routeCollector.getDistance(), distance) || this.isRepeatedly(route)) {
            return;
        }

        if (this.isArrivedToDestination(route) && this.isDecreased(routeCollector.getDistance(), distance)) {
            routeCollector.setDistance(distance);
            routeCollector.setRoute(route);
            return;
        }

        List<Edge> edges = this.getEdgesOfOrigin(partOfRoute.getDestination());
        for (Edge edge : edges) {
            this.depthFirstSearch(edge, route.concat(edge.getDestination()), distance + edge.getDistance(), routeCollector);
        }
    }

    public boolean isDecreased(Integer sourceDistance, Integer targetDistance) {
        if (Objects.isNull(sourceDistance) || targetDistance < sourceDistance) {
            return true;
        }
        return false;
    }

    private boolean isArrivedToDestination(String route) {
        return route.startsWith(this.origin) && route.endsWith(this.destination);
    }

    private boolean isRepeatedly(String route) {
        // 根据人工设置一个最大的沿途站数量来避免陷入无限循环
        return route.length() > MAX_NUMBER_OF_STOP_STATION;
    }

    private List<Edge> getEdgesOfOrigin(String origin) {
        return this.edges
                .stream()
                .filter(o -> o.getOrigin().equals(origin))
                .collect(toList());
    }

    private class RouteCollector {
        private Integer distance;
        private String route;

        public RouteCollector() {
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }

        public void setRoute(String route) {
            this.route = route;
        }

        public Integer getDistance() {
            return this.distance;
        }

        public String getRoute() {
            return route;
        }
    }
}
