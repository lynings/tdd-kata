package pers.lyning.kata.fizzbuzzwhizz;

import java.util.List;

public class Student {

    public static String countOff(final Integer position, final List<GameRule> gameRules) {
        // 这条规则优先级最高，所以放在这里
        if (position.toString().contains(gameRules.get(0).getNumber().toString())) {
            return gameRules.get(0).getTerm();
        }
        String term = gameRules
                .stream()
                .filter(rule -> isMultiple(position, rule.getNumber()))
                .map(rule -> rule.getTerm())
                .reduce((t1, t2) -> t1 + t2)
                .orElse(position.toString());
        return term;
    }

    private static boolean isMultiple(Integer divisor, Integer dividend) {
        return divisor % dividend == 0;
    }
}
