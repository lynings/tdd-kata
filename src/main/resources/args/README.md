## Args
About this Kata

This Kata is presented in Robert C.. Martin’s book “Clean Code”, chapter 14.

**Problem Description**

Most of us have had to parse command-line arguments from time to time. If we don’t have a convenient utility, then we simply walk the array of strings that is passed into the main function. There are several good utilities available from various sources, but they probably don’t do exactly what we want. So let’s write another one!

The arguments passed to the program consist of flags and values. Flags should be one character, preceded by a minus sign. Each flag should have zero, or one value associated with it.

You should write a parser for this kind of arguments. This parser takes a schema detailing what arguments the program expects. The schema specifies the number and types of flags and values the program expects.

Once the schema has been specified, the program should pass the actual argument list to the args parser. It will verify that the arguments match the schema. The program can then ask the args parser for each of the values, using the names of the flags. The values are returned with the correct types, as specified in the schema.

For example if the program is to be called with these arguments:
```shell
-l -p 8080 -d /usr/logs
```
this indicates a schema with 3 flags: l, p, d. The “l” (logging) flag has no values associated with it, it is a boolean flag, True if present, False if not. the “p” (port) flag has an integer value, and the “d” (directory) flag has a string value.

If a flag mentioned in the schema is missing in the arguments, a suitable default value should be returned. For example “False” for a boolean, 0 for a number, and “” for a string. If the arguments given do not match the schema, it is important that a good error message is given, explaining exactly what is wrong.

If you are feeling ambitious, extend your code to support lists eg

```shell
-g this,is,a,list -d 1,2,-3,5
```

So the “g” flag indicates a list of strings, [“this”, “is”, “a”, “list”] and the “d” flag indicates a list of integers, [1, 2, -3, 5].

Make sure your code is extensible, in that it is straightforward and obvious how to add new types of values.

**Clues**

What the schema should look like and how to specify it is deliberately left vague in the Kata description. An important part of the Kata is to design a concise yet readable format for it.

**Suggested Test Cases**

make sure you have a test with a negative integer (confusing - sign)
the order of the arguments need not match the order given in the schema.
have some tests that suitable default values are correctly assigned if flags given in the schema are missing in the args given.
Comments from those who are working on this Kata

In Robert C. Martin’s book there is a full worked solution written in Java. He mentions in a footnote on page 200 that he has also solved it in Ruby. His Java code is available on github.com/unclebob/javaargs/tree/master, and the Ruby version is available on github.com/unclebob/rubyargs/tree/master

## 案例分析
- arguments consist of  flags and values
- flags should be on character, preceded by a minus sign, each flag should have zero, or one value associated with it
- parser args, takes a schema. Then return correct types and values
- when schema mismatch flag, then return suitable default value and type

## Schema
|schema|description|
|----|----|
|char    |Boolean arg.|
|char*   |String arg.|
|char#   |Integer arg.|
|char##  |double arg.|
|char[*] |one element of a string array.|
|char[#] |one element of a int array.|
|char[##] |one element of a double array.|
|char[&] |set arg.|
|char[&&] |map arg.|
|char[help] |schema description.|

## 程序设计
```java
public class ArgsParser {
    public ArgsParser(String schema, String args);
    public <T> T getValue(String flag);
    public boolean hasFlag(String flag);
}
```

## 任务分解
- [x] 判断 flag 是否存在
- [x] 字符创解析器（schema: *）
    - [x] 默认返回 ""
    - [x] 返回 args 指定的字符串
- [x] 整数解析器（schema: #）
    - [x] 默认返回 0
    - [x] 返回 args 指定的整数
- [x] 浮点数解析器（schema: ##）
    - [x] 默认返回 0.0
    - [x] 返回 args 指定的浮点数
- [x] Boolean 解析器（schema: <flag>）
    - [x] 默认返回 false
    - [x] 当存在时返回 true
- [x] 字符串数组解析器（schema: [*]）
    - [x] 默认返回 empty 数组
    - [x] 返回 args 指定的字符串数组
- [x] 整数数组解析器（schema: [#]）
    - [x] 默认返回 empty 数组
    - [x] 返回 args 指定的整数数组
- [x] 浮点数数组解析器（schema: [##]）
    - [x] 默认返回 empty 数组
    - [x] 返回 args 指定的浮点数数组
- [x] Set 解析器（schema: [&]）
    - [x] 默认返回 empty set
    - [x] 返回 args 指定的值，并且不能重复
- [x] Map 解析器（schema: [&&]）
    - [x] 默认返回 empty map
    - [x] 指定并返回 key:value 格式的数据
- [x] help 解析器（schema: [help]）
    - [x] 默认返回 all schema description, 例如 schema: h[help], args: -h
    - [x] 返回指定 schema 的描述，例如 schema: h[help], args: -h [*]
- [x] 同时接收并处理多种args，例如：-n 10 -s Hello World!!! -m name:lyning,age:25
- [x] 增加一个ArgsException用于统一抛出异常
- [x] 有效性验证
    - [x] 验证无效 schema 
    - [x] 验证无效 args
    - [x] 验证无效 flag
