package pers.lyning.kata.trains;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author lyning
 */
public class PointToPointDistanceRouteStrategy implements RouteStrategy {

    private List<Edge> edges;
    private String route;

    public PointToPointDistanceRouteStrategy(List<Edge> edges, String route) {
        this.edges = edges;
        this.route = route;
    }

    @Override
    public Integer calculate() throws Exception {
        List<Edge> routes = this.matchRoute();
        Integer distance = routes
                .stream()
                .map(Edge::getDistance)
                .reduce(Integer::sum)
                .get();
        return distance;
    }

    private List<Edge> matchRoute() throws Exception {
        List<Edge> routes = new ArrayList<>();
        String[] nodeArr = route.split("");
        for (int i = 1, len = nodeArr.length; i < len; i++) {
            String edge = nodeArr[i - 1] + nodeArr[i];
            Optional<Edge> edgeOptional = this.findEdge(edge);
            if (edgeOptional.isPresent()) {
                routes.add(edgeOptional.get());
            }
        }

        if (routes.size() != nodeArr.length - 1) {
            throw new Exception("NO SUCH ROUTE");
        }
        return routes;
    }

    private Optional<Edge> findEdge(String route) {
        Optional<Edge> edgeOptional = this.edges
                .stream()
                .filter(o -> (o.getOrigin() + o.getDestination()).equals(route))
                .findFirst();
        return edgeOptional;
    }
}
