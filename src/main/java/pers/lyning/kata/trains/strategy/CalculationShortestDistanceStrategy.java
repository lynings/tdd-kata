package pers.lyning.kata.trains.strategy;

import pers.lyning.kata.trains.Digraph;
import pers.lyning.kata.trains.Edge;
import pers.lyning.kata.trains.Route;

import java.util.List;
import java.util.Objects;

/**
 * @author lyning
 */
public class CalculationShortestDistanceStrategy implements Strategy {

    private Digraph digraph;
    private final Route route;
    private final ShortestRoute shortestRoute;
    private final Integer MAX_NUMBER_OF_STOP_STATION = 10;

    public CalculationShortestDistanceStrategy(Route route) {
        this.route = route;
        this.shortestRoute = new ShortestRoute();
    }

    @Override
    public Integer execute(Digraph digraph) {
        this.digraph = digraph;
        this.depthFirstSearch();
        return this.shortestRoute.getDistance();
    }

    private void depthFirstSearch() {
        List<Edge> edges = this.digraph.getEdgesOfOrigin(this.route.getOrigin());
        for (Edge edge : edges) {
            this.depthFirstSearch(edge, edge.getName(), edge.getDistance());
        }
    }

    private void depthFirstSearch(Edge partOfRoute, String route, Integer distance) {
        if (!this.shortestRoute.isShortest(distance) || this.isRepeatedly(route)) {
            return;
        }

        if (this.route.isEquals(route) && this.shortestRoute.isShortest(distance)) {
            shortestRoute.setDistance(distance);
            shortestRoute.setRoute(route);
            return;
        }

        List<Edge> edges = this.digraph.getEdgesOfOrigin(partOfRoute.getEndNode());
        for (Edge edge : edges) {
            this.depthFirstSearch(edge, route.concat(edge.getEndNode()), distance + edge.getDistance());
        }
    }

    private boolean isRepeatedly(String route) {
        // 根据人工设置一个最大的沿途站数量来避免陷入无限循环
        return route.length() > MAX_NUMBER_OF_STOP_STATION;
    }

    private class ShortestRoute {
        private Integer distance;
        private String route;

        public ShortestRoute() {
        }

        public boolean isShortest(Integer distance) {
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
