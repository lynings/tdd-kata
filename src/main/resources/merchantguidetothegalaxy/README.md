## Merchant's Guide to the Galaxy
You decided to give up on earth after the latest financial collapse left 99.99% of the earth's population with 0.01% of the wealth.Luckily, with the scant sum of money that is left in your account, you are able to afford to rent a spaceship, leave earth, and fly all over the galaxy to sell common metals and dirt (which apparently is worth a lot).

Buying and selling over the galaxy requires you to convert numbers and units, and you decided to write a program to help you.

The numbers used for intergalactic transactions follows similar convention to the roman numerals and you have painstakingly collected the appropriate translation between them.

| Symbol      | Value |
| ----------- | ----------- |
| I | 1 |
| V | 5  |
| X | 10 |
| L | 50 |
| C | 100 |
| D | 500 |
| M | 1,000 |

Numbers are formed by combining symbols together and adding the values. For example, MMVI is 1000 + 1000 + 5 + 1 = 2006. Generally, symbols are placed in order of value, starting with the largest values. When smaller value sprecede larger values, the smaller values are subtracted from the larger values, and the result is added to the total. For example MCMXLIV = 1000 +(1000 − 100) + (50 − 10) + (5 − 1) = 1944.

- The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.) "D", "L", and "V" can never be repeated.
- "I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted.
- Only one small-value symbol may be subtracted from any large-value symbol.
- A number written in [16]Arabic numerals can be broken into digits. For example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be treated separately. In the above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.(Source: Wikipedia ( [17]http://en.wikipedia.org/wiki/Roman_numerals)

Input to your program consists of lines of text detailing your notes on the conversion between intergalactic units and roman numerals.

 

You are expected to handle invalid queries appropriately.

 

Test input:

glob is I

prok is V

pish is X

tegj is L

glob glob Silver is 34 Credits

glob prok Gold is 57800 Credits

pish pish Iron is 3910 Credits

how much is pish tegj glob glob ?

how many Credits is glob prok Silver ?

how many Credits is glob prok Gold ?

how many Credits is glob prok Iron ?

how much wood could a woodchuck chuck if a woodchuck could chuckwood ?

 

Test Output:

pish tegj glob glob is 42

glob prok Silver is 68 Credits

glob prok Gold is 57800 Credits

glob prok Iron is 782 Credits

I have no idea what you are talking about


## 案例分析
1. 我需要购买和销售物资，因此需要一个能够转换星际中的数字和单位的功能，以便于我能够进行交易（需求）。
2. 我需要将星际数字和文字转换成罗马数字，因此我制作了一张对照表，以便于我完成货币的换算。
3. 通过将符号组合在一起并添加值来形成数字。例如，MMVI是1000 + 1000 + 5 + 1 = 2006.
通常，符号按值的顺序放置，从最大值开始。当较小的值扩展较大的值时，从较大的值中减去较小的值，并将结果添加到总数中。
例如，MCMXLIV = 1000 +（1000-100）+（50-10）+（5-1）= 1944。
4. 符号“I”，“X”，“C”和“M”可以连续重复三次，但不能再重复。 （如果第三个和第四个以较小的值分隔，它们可能会出现四次，例如XXXIX。）“D”，“L”和“V”永远不会重复。
5. “I”只能被“V”和“X”减去。 “X”只能被“L”和“C”减去。 “C”只能被“D”和“M”中减去。永远不能减去“V”，“L”和“D”。 

## 符号对照表
| Symbol      | Value |
| ----------- | ----------- |
| I | 1 |
| V | 5  |
| X | 10 |
| L | 50 |
| C | 100 |
| D | 500 |
| M | 1,000 |

## 程序设计
```java
class SymbolConverter {
    public Integer convert(String symbol);
}

class SymbolCalculator {
    public Integer calc(String symbols);
}


```

## 任务分解
- [x] 验证 MM=1000+1000=2000.
- [x] 验证 IV=5-1=4.
- [x] MMVI是1000 + 1000 + 5 + 1 = 2006.
- [x] IVMM是 5 - 1 + 1000 + 1000 = 2004.
- [x] MCMXLIV = 1000 +（1000-100）+（50-10）+（5-1）= 1944.
- [x] XXXIX = 10 + 10 + 10 + (10 - 1) = 39.
- [x] 转换星际单位和罗马数字之间的注释的文本行.
- [x] 验证在给定的测试数据下，pish tegj glob glob is 42.
- [x] 验证在给定的测试数据下，glob prok Silver is 68 Credits.
- [x] 验证在给定的测试数据下，glob prok Gold is 57800 Credits.
- [x] 验证在给定的测试数据下，glob prok Iron is 782 Credits.
- [x] 当输入不正确时，输出 I have no idea what you are talking about.
- [X] “D”，“L”和“V”不能重复出现.
- [X] 除了特殊情况，符号“I”，“X”，“C”和“M”可以连续出现三次.
- [x] 验证 “X”只能被“L”和“C”减去.
- [x] 验证“C”只能被“D”和“M”中减去.
- [x] 验证 “I”只能被“V”和“X”减去.
- [x] 验证永远不能减去“V”，“L”和“D”
- [x] 重构GalaxyGuide.receiveConvert(text)
- [x] 重构InputHandler