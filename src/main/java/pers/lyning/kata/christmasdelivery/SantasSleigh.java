package pers.lyning.kata.christmasdelivery;

import java.util.List;

/**
 * @author
 */
public interface SantasSleigh {

    /**
     * get present forms from santas sleigh
     *
     * @return
     */
    List<PresentForm> getPresentForms();

    /**
     * pack present in the santas sleigh
     *
     * @param present
     */
    void pack(Present present);
}
