package pers.lyning.kata.christmasdelivery;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyning
 */
public class Present {

    private final String name;
    private final List<Present> presents = new ArrayList<>();

    private Present(String name) {
        this.name = name;
        this.presents.add(this);
    }

    public static Present A() {
        return new Present("A");
    }

    public static Present B() {
        return new Present("B");
    }

    public static Present C() {
        return new Present("B");
    }

    public static Present D() {
        return new Present("D");
    }
}
