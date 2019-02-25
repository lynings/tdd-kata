package pers.lyning.kata.fizzbuzzwhizz;

import java.util.List;

public class Student {

    public static String countOff(Integer position, List<GameRule> gameRules) {
        if (position % gameRules.get(0).getRandom() == 0) {
            return gameRules.get(0).getTerm();
        } else if (position % gameRules.get(1).getRandom() == 0) {
            return gameRules.get(1).getTerm();
        } else if (position % gameRules.get(2).getRandom() == 0) {
            return gameRules.get(2).getTerm();
        }
        return position.toString();
    }
}
