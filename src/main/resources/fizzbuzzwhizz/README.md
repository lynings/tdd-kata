## FizzBuzzWhizz
![](https://user-gold-cdn.xitu.io/2019/2/25/169253f5136938b3?w=640&h=481&f=jpeg&s=236403)

你是一名体育老师，在某次课距离下课还有五分钟时，你决定搞一个游戏。此时有 100 名学生在上课。游戏的规则是：

1. 你首先说出三个不同的特殊数，要求必须是个位数，比如 3、5、7。
2. 让所有学生排成一队，然后按顺序报数。
3. 学生报数时，如果所报数字是第一个特殊数（3）的倍数，那么不能说该数字，而要说 Fizz；如果所报数字是第二个特殊数（5）的倍数，那么要说 Buzz；如果所报数字是第三个特殊数（7）的倍数，那么要说 Whizz。
4. 学生报数时，如果所报数字同时是两个特殊数的倍数情况下，也要特殊处理，比如第一个特殊数和第二个特殊数的倍数，那么不能说该数字，而是要说 FizzBuzz, 以此类推。如果同时是三个特殊数的倍数，那么要说 FizzBuzzWhizz。
5. 学生报数时，如果所报数字包含了第一个特殊数，那么也不能说该数字，而是要说相应的单词，比如本例中第一个特殊数是 3，那么要报 13 的同学应该说 Fizz。如果数字中包含了第一个特殊数，那么忽略规则 3 和规则 4，比如要报 35 的同学只报 Fizz，不报 BuzzWhizz。


现在，我们需要你完成一个程序来模拟这个游戏，它首先接受 3 个特殊数，然后输出 100 名学生应该报数的数或单词。比如：

输入：

3,5,7

输出（片段）：

> "1", "2", "Fizz", "4", "Buzz", "Fizz", "Whizz", "8", "Fizz", "Buzz",
"11", "Fizz", "Fizz", "Whizz", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz",
"FizzWhizz", "22", "Fizz", "Fizz", "Buzz", "26", "Fizz", "Whizz", "29", "Fizz",
"Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Buzz",
"41", "FizzWhizz", "Fizz", "44", "FizzBuzz", "46", "47", "Fizz", "Whizz", "Buzz",
"Fizz", "52", "Fizz", "Fizz", "Buzz", "Whizz", "Fizz", "58", "59", "FizzBuzz",
"61", "62", "Fizz", "64", "Buzz", "Fizz", "67", "68", "Fizz", "BuzzWhizz",
"71", "Fizz", "Fizz", "74", "FizzBuzz", "76", "Whizz", "Fizz", "79", "Buzz",
"Fizz", "82", "Fizz", "FizzWhizz", "Buzz", "86", "Fizz", "88", "89", "FizzBuzz",
"Whizz", "92", "Fizz", "94", "Buzz", "Fizz", "97", "Whizz", "Fizz", "Buzz"

## 案例分析

- 首先说出三个不同的特殊数，要求必须是个位数，比如 3、5、7。
- 学生顺序报数
- 如果所报数字是第一个特殊数（3）的倍数，要说 Fizz。
- 如果所报数字是第二个特殊数（5）的倍数，要说 Buzz；
- 如果所报数字是第三个特殊数（7）的倍数，要说 Whizz。
- 如果所报数字是第一个特殊数和第二个特殊数的倍数，要说 FizzBuzz，以此类推；如果同时是三个特殊数的倍数，那么要说 FizzBuzzWhizz。
- 如果所报数字包含了第一个特殊数，要说 Fizz（忽略规则 3 和规则 4，比如要报 35 的同学只报 Fizz，不报 BuzzWhizz）。

|术语|描述|
|----|----|
|Game|游戏|
|SpecialNumber|特殊数字|
|Number|数字|
|countOff|报数|
|divisible|可被整除（倍数）|

## 初步设计
```java
class Number {
    public Number(Integer value);
    public boolean isDivisibleBy(Integer number);
}

class SpecialNumber {
    public SpecialNumber(Integer number, String word);
}

class WordMatcher {
    public WordMatcher(SpecialNumber first, SpecialNumber second, SpecialNumber third);
    public String match(Number number);
}

class Game {
    public Game(Integer firstNumber, Integer secondNumber, Integer thirdNumber);
    public List<String> countOff(Integer players);
}
```

## 任务分解