package pers.lyning.kata.christmasdelivery;

import java.util.List;

/**
 * @author lyning
 */
class PresentForm {
    private final Destination destination;
    private final List<Present> presents;

    private PresentForm(List<Present> presents, Destination destination, StatusEnum status) {
        this.presents = presents;
        this.destination = destination;
    }

    public static PresentForm cancel(List<Present> presents, Destination destination) {
        return new PresentForm(presents, destination, StatusEnum.CANCEL);
    }

    public static PresentForm create(List<Present> presents, Destination destination) {
        return new PresentForm(presents, destination, StatusEnum.CANCEL);
    }
}
