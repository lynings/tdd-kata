package pers.lyning.kata.fizzbuzzwhizz;

import java.util.ArrayList;
import java.util.List;

public class Rule {

    private List<Item> items;

    public Rule(final List<Integer> specialNumbers) {
        this.items = new ArrayList<>(3);
        this.items.add(new Item(specialNumbers.get(0), "Fizz"));
        this.items.add(new Item(specialNumbers.get(1), "Buzz"));
        this.items.add(new Item(specialNumbers.get(2), "Whizz"));
    }

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

    public String match(Integer number) {
        if (number.toString().contains(items.get(0).getNumber().toString())) {
            return items.get(0).getWord();
        }
        return items
                .stream()
                .filter(item -> isMultiple(number, item.getNumber()))
                .map(item -> item.getWord())
                .reduce((w1, w2) -> w1 + w2)
                .orElse(number.toString());
    }

    private class Item {
        private Integer number;
        private String word;

        public Item(Integer number, String word) {
            this.number = number;
            this.word = word;
        }

        public Integer getNumber() {
            return number;
        }

        public String getWord() {
            return word;
        }
    }
}
