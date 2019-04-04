package pers.lyning.kata.trains;

import java.util.Optional;

/**
 * @author lyning
 */
public class PointToPointDistanceRouteStrategy implements RouteStrategy {

    private Digraph digraph;
    private String route;

    public PointToPointDistanceRouteStrategy(String route) {
        this.route = route;
    }

    @Override
    public Integer calculate(Digraph digraph) throws Exception {
        this.digraph = digraph;
        return this.getDistance();
    }

    private Integer getDistance() throws Exception {
        Integer distance = 0;
        String[] nodeArr = route.split("");
        for (int i = 1, len = nodeArr.length; i < len; i++) {
            String edge = nodeArr[i - 1] + nodeArr[i];
            Optional<Edge> edgeOptional = this.findEdge(edge);
            if (edgeOptional.isPresent()) {
                distance += edgeOptional.get().getDistance();
            }
        }

        if (distance == 0) {
            throw new Exception("NO SUCH ROUTE");
        }
        return distance;
    }

    private Optional<Edge> findEdge(String route) {
        Optional<Edge> edgeOptional = this.digraph.getEdges()
                .stream()
                .filter(o -> o.getName().equals(route))
                .findFirst();
        return edgeOptional;
    }
}
