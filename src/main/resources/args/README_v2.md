## Args
About this Kata

This Kata is presented in Robert C.. Martin’s book “Clean Code”, chapter 14.

**Problem Description**

Most of us have had to parse command-line arguments from time to time. If we don’t have a convenient utility, then we simply walk the array of strings that is passed into the main function. There are several good utilities available from various sources, but they probably don’t do e actly what we want. So let’s write another one!

The arguments passed to the program consist of flags and values. Flags should be one character, preceded by a minus sign. Each flag should have zero, or one value associated with it.

You should write a parser for this kind of arguments. This parser takes a schema detailing what arguments the program e pects. The schema specifies the number and types of flags and values the program e pects.

Once the schema has been specified, the program should pass the actual argument list to the args parser. It will verify that the arguments match the schema. The program can then ask the args parser for each of the values, using the names of the flags. The values are returned with the correct types, as specified in the schema.

For e ample if the program is to be called with these arguments:
```shell
-l -p 8080 -d /usr/logs
```
this indicates a schema with 3 flags: l, p, d. The “l” (logging) flag has no values associated with it, it is a boolean flag, True if present, False if not. the “p” (port) flag has an integer value, and the “d” (directory) flag has a string value.

If a flag mentioned in the schema is missing in the arguments, a suitable default value should be returned. For e ample “False” for a boolean, 0 for a number, and “” for a string. If the arguments given do not match the schema, it is important that a good error message is given, e plaining e actly what is wrong.

If you are feeling ambitious, e tend your code to support lists eg

```shell
-g this,is,a,list -d 1,2,-3,5
```

So the “g” flag indicates a list of strings, [“this”, “is”, “a”, “list”] and the “d” flag indicates a list of integers, [1, 2, -3, 5].

Make sure your code is e tensible, in that it is straightforward and obvious how to add new types of values.

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
|char[*] |one element of a string array.|
|char[#] |one element of a int array.|
|char[&&] |map arg.|


## 任务分解 
- [ ] 字符创解析][]器（schema: *）
    - [ ] 默认返回 ""
    - [ ] 返回 args 指定的字符串
- [ ] 整数解析器（schema: #）
    - [ ] 默认返回 0
    - [ ] 返回 args 指定的整数
- [ ] Boolean 解析器（schema: <flag>）
    - [ ] 默认返回 false
    - [ ] 当存在时返回 true
- [ ] 字符串数组解析器（schema: [*]）
    - [ ] 默认返回 empty 数组
    - [ ] 返回 args 指定的字符串数组
- [ ] 整数数组解析器（schema: [#]）
    - [ ] 默认返回 empty 数组
    - [ ] 返回 args 指定的整数数组
- [ ] Map 解析器（schema: [&&]）
    - [ ] 默认返回 empty map
    - [ ] 指定并返回 key:value 格式的数据
- [ ] 同时接收并处理多种args，例如：-n 10 -s Hello World!!! -m name:lyning,age:25
- [ ] 增加一个ArgsException用于统一抛出异常
- [ ] 有效性验证
    - [ ] 验证无效 schema 
    - [ ] 验证无效 args
    - [ ] 验证无效 flag
- [x] 解析 arguments    
- [x] 验证 arguments 存在指定的 flag
- [x] 通过 flag 获取 values