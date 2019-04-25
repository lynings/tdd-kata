## FizzBuzz
Imagine the scene. You are eleven years old, and in the five minutes before the end of the lesson, your Maths teacher decides he should make his class more “fun” by introducing a “game”. He e plains that he is going to point at each pupil in turn and ask them to say the ne t number in sequence, starting from one. The “fun” part is that if the number is divisible by three, you instead say “Fizz” and if it is divisible by five you say “Buzz”. So now your maths teacher is pointing at all of your classmates in turn, and they happily shout “one!”, “two!”, “Fizz!”, “four!”, “Buzz!”… until he very deliberately points at you, fi ing you with a steely gaze… time stands still, your mouth dries up, your palms become sweatier and sweatier until you finally manage to croak “Fizz!”. Doom is avoided, and the pointing finger moves on.

So of course in order to avoid embarassment infront of your whole class, you have to get the full list printed out so you know what to say. Your class has about 33 pupils and he might go round three times before the bell rings for breaktime. Ne t maths lesson is on Thursday. Get coding!

Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print “FizzBuzz “.

Sample output:
> "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", 
"11", "Fizz", "13", "14", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz", 
"Fizz", "22", "23", "Fizz", "Buzz", "26", "Fizz", "28", "29", "FizzBuzz", 
"31", "32", "Fizz", "34", "Buzz", "Fizz", "37", "38", "Fizz", "Buzz", "41", 
"Fizz", "43", "44", "FizzBuzz", "46", "47", "Fizz", "49", "Buzz", 
"Fizz", "52", "53", "Fizz", "Buzz", "56", "Fizz", "58", "59", "FizzBuzz", 
"61", "62", "Fizz", "64", "Buzz", "Fizz", "67", "68", "Fizz", "Buzz", 
"71", "Fizz", "73", "74", "FizzBuzz", "76", "77", "Fizz", "79", "Buzz", 
"Fizz", "82", "83", "Fizz", "Buzz", "86", "Fizz", "88", "89", "FizzBuzz",
"91", "92", "Fizz", "94", "Buzz", "Fizz", "97", "98", "Fizz", "Buzz" 

## Stage 2 - new requirements
> * A number is fizz if it is divisible by 3 or if it has a 3 in it
> * A number is buzz if it is divisible by 5 or if it has a 5 in it

Sample output:
> "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
                  "11", "Fizz", "Fizz", "14", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz",
                  "Fizz", "22", "Fizz", "Fizz", "Buzz", "26", "Fizz", "28", "29", "FizzBuzz",
                  "Fizz", "Fizz", "Fizz", "Fizz", "FizzBuzz", "Fizz", "Fizz", "Fizz", "Fizz", "Buzz", "41",
                  "Fizz", "Fizz", "44", "FizzBuzz", "46", "47", "Fizz", "49", "Buzz",
                  "FizzBuzz", "Buzz", "FizzBuzz", "FizzBuzz", "Buzz", "Buzz", "FizzBuzz", "Buzz", "Buzz", "FizzBuzz",
                  "61", "62", "Fizz", "64", "Buzz", "Fizz", "67", "68", "Fizz", "Buzz",
                  "71", "Fizz", "Fizz", "74", "FizzBuzz", "76", "77", "Fizz", "79", "Buzz",
                  "Fizz", "82", "Fizz", "Fizz", "Buzz", "86", "Fizz", "88", "89", "FizzBuzz",
                  "91", "92", "Fizz", "94", "Buzz", "Fizz", "97", "98", "Fizz", "Buzz"

## 案例分析
- if the number is divisible by three, you instead say “Fizz” 
- if it is divisible by five you say “Buzz”
- if the number is multiples of both three and five print “FizzBuzz “.
- A number is fizz if it is divisible by 3 or if it has a 3 in it (new requirements)
- A number is buzz if it is divisible by 5 or if it has a 5 in it (new requirements)


|术语|描述|
|----|----|
|game|游戏|
|number|数字|
|divisible|可被整除|
|turn|转动，表示玩家一个接一个转动起来|

## 程序设计
```java
class Number {
    public Number(int value);
    public boolean isFizz();
    public boolean isBuzz();
    public boolean isFizzBuzz();
}

class Game {
    public Game(int players);
    public List<String> play();
}
```

## 任务分解
- [x] 完成 Number 类
    - [x] 创建 Number 类
    - [x] 增加 isFizz() 方法
    - [x] 增加 isBuzz() 方法
    - [x] 增加 isFizzBuzz() 方法
- [x] 完成 Game 类
    - [x] 创建 Game 类
    - [x] 增加 play() 方法
- [x] 补充新需求
    - [x] isFizz() 新增包含数字 3 返回 true 的逻辑 
    - [x] isBuzz() 新增包含数字 5 返回 true 的逻辑 