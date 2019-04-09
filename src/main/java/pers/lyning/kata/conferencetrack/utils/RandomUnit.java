package pers.lyning.kata.conferencetrack.utils;

import java.util.Random;

/**
 * @author lyning
 */
public class RandomUnit {

    /**
     * 生成 [min, max] 范围的随机数
     *
     * @param min
     * @param max
     * @return
     */
    public static int random(int min, int max) {
        if (max == 0) {
            return 0;
        }
        return (new Random().nextInt(max + 1)) % (max - min + 1) + min;
    }
}
