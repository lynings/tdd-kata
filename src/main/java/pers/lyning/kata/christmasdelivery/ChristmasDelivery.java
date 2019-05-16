package pers.lyning.kata.christmasdelivery;

import java.util.List;

/**
 * @author lyning
 */
public class ChristmasDelivery {
    private final List<Deliverer> presentDeliverers;
    private final List<PresentForm> presentForms;

    public ChristmasDelivery(List<PresentForm> presentForms, List<Deliverer> presentDeliverers) {
        this.presentForms = presentForms;
        this.presentDeliverers = presentDeliverers;

        this.startMachine();
        this.packing();
    }

    public SantasSleigh packTo(SantasSleigh santasSleigh) {
        return santasSleigh;
    }
}
