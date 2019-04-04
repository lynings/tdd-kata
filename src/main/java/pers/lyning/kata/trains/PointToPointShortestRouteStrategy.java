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
        ResultCollector resultCollector = this.getShortestDistance();
        return resultCollector.getDistance();
    }

    private ResultCollector getShortestDistance() {
        return this.depthFirstSearch();
    }

    private ResultCollector depthFirstSearch() {
        ResultCollector resultCollector = new ResultCollector();
        List<Edge> edges = this.getEdgesOfOrigin(this.origin);
        for (Edge edge : edges) {
            String route = edge.getOrigin() + edge.getDestination();
            this.depthFirstSearch(edge, route, edge.getDistance(), resultCollector);
        }
        return resultCollector;
    }

    private void depthFirstSearch(Edge partOfRoute, String route, Integer distance, ResultCollector resultCollector) {
        if (!resultCollector.isMatch(distance) || this.isRepeatedly(route)) {
            return;
        }

        if (this.isArrivedToDestination(route) && resultCollector.isMatch(distance)) {
            resultCollector.setDistance(distance);
            resultCollector.setRoute(route);
            return;
        }

        List<Edge> edges = this.getEdgesOfOrigin(partOfRoute.getDestination());
        for (Edge edge : edges) {
            this.depthFirstSearch(edge, route + edge.getDestination(), distance + edge.getDistance(), resultCollector);
        }
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

    private class ResultCollector {
        private Integer distance;
        private String route;

        public ResultCollector() {
        }

        public boolean isMatch(Integer distance) {
            if (Objects.isNull(this.distance) || distance < this.distance) {
                return true;
            }
            return false;
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
