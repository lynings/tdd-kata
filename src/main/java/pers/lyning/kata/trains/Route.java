package pers.lyning.kata.trains;

/**
 * @author lyning
 */
public class Route {
    private final String destination;
    private final String origin;
    private Integer distance;

    public Route(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public Route(String origin, String destination, Integer distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }

    public String getDestination() {
        return this.destination;
    }

    public Integer getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.getOrigin() + this.getDestination();
    }

    public String getOrigin() {
        return this.origin;
    }

    public boolean isEquals(String route) {
        return route.startsWith(this.getOrigin()) && route.endsWith(this.getDestination());
    }
}
