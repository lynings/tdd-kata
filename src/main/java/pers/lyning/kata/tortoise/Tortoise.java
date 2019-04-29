package pers.lyning.kata.tortoise;

/**
 * @author lyning
 */
public class Tortoise {

    private static final int ONE_SECOND = 1;

    public static int[] race(int v1, int v2, int lead) {
        if (v1 == v2) {
            return new int[]{-1, -1, -1};
        }

        Speed speedA = Speed.init(v1, lead);
        Speed speedB = Speed.init(v2, 0);
        Time time = Time.second(0);
        while (!speedB.nextSeconds().catchTo(speedA.nextSeconds())) {
            time.increase(ONE_SECOND);
        }
        return new int[]{time.years(), time.minutes(), time.seconds()};
    }
}


