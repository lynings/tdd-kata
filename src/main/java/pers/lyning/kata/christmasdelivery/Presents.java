package pers.lyning.kata.christmasdelivery;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyning
 */
public class Presents {
    private final Chain chain = new Chain(this);
    private final List<Present> presents = new ArrayList<>();

    public Chain A() {
        this.presents.add(Present.A());
        return this.chain;
    }

    public Chain B() {
        this.presents.add(Present.B());
        return this.chain;
    }

    public Chain C() {
        this.presents.add(Present.C());
        return this.chain;
    }

    public Chain D() {
        this.presents.add(Present.D());
        return this.chain;
    }

    public static Presents chain() {
        return new Presents();
    }

    static class Chain {
        private final Presents presents;

        public Chain(Presents presents) {
            this.presents = presents;
        }

        public Presents and() {
            return this.presents;
        }

        public List<Present> end() {
            return this.presents.presents;
        }
    }
}
