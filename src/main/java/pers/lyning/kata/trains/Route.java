package pers.lyning.kata.trains;

/**
 * @author lyning
 */
public class Route {
    private String origin;
    private String destination;
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

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getDistance() {
        return distance;
    }

    public String getName() {
        return this.getOrigin() + this.getDestination();
    }

    public boolean isEquals(String route) {
        if (route.startsWith(this.getOrigin()) && route.endsWith(this.getDestination())) {
            return true;
        }
        return false;
    }
}
