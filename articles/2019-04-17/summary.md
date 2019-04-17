### 提高 TDD 效率总结

![大图](picture.jpeg)

最近在熊节老师的带领下，很多小伙伴们进入了[TDD和重构练功房](https://mp.weixin.qq.com/s/y4wqiT1JrkzR3MVfLA1FqQ)，为什么来练功房，因为基本功太差，有幸作为基本功最差的学员（没有之一），在经过几天的练习，逐渐感受到自己的基本功真的很差。好在也逐渐领悟一些提高效率的诀窍，因此想赶紧做一下总结，希望可以给予新手一些帮助，如果有哪里写得不合理的地方，欢迎指正。

### 承认能力不足
**承认自己代码写得烂，基本功不行。** 这很难，没关系，这可能是事实，接受他，慢慢会有意外收获的，而且还会很感谢那些“怼”自己和提供建议的大神，因为对我来说，什么是“好”的定义正在发生变化。

### 专注
想要提高效率的第一件事就是专注，如何才能专注呢？**重视它，重视一件事，就会发现脑海里只有它，在还没有完成之前，这件事目前的优先级最高**。

### 使用快捷键
**在 TDD 时强迫自己使用快捷键，尽量减少使用鼠标和触摸板**。如果还想把使用 IDE 的效率调到极致，还需要发掘新的快捷键。分享最近新学到的和新设置的快捷键(Intellij IDEA)：

- 窗口控制
    - 打开/关闭 左侧项目视图 => Command + 1
    - 打开/关闭 底部Debug视图 => Command + 5
    - 查看文件结构 => Command + 7
    - 打开/关闭 Terminal => Option + T
    - 关闭所有 Tool Window => Control + Option + C
- 分屏
    - 垂直分屏 => Option + 1
    - 水平分屏 => Option + 2
    - 分屏切换 => Option + Tab
    - 文件切换 => Shift + Command + [/]
- 测试
    - Run/Debug 立即测试 => Control + R / Control + D 
    - Run/Debug 选择测试 => Control + Option + R / Control + Option + D
    - Step Over => Option + N
    - Resume Program => Option + Command + R
    - Evaluate Expression => Contrl + Command + E
    - 生成单元测试模板 => Command + N
- 自动生成代码或文件 => Option + Enter 、Command + N

### 巧用伪代码
**如果使用快捷键可以使编码效率更快，那么巧用伪代码能助编码效率上一个台阶**。TDD 有相当一部分代码是不需要手写的，而是巧用伪代码，然后交给 IDE 自动生成，例如（我从群里面拿的两张图）：

![](https://user-gold-cdn.xitu.io/2019/4/17/16a2aa80f3d958a7?w=970&h=558&f=png&s=373105)

![](https://user-gold-cdn.xitu.io/2019/4/17/16a2aa82bb4c9331?w=582&h=242&f=png&s=98425)

这种方式可以**先明确做什么、需要什么和得到什么**，避免一开始就陷入实现细节。熟练掌握这种思维，大部分的类、函数、输入和返回值类型等代码片段都可以通过先写伪代码，再交给 IDE 自动生成。

### 读懂题目
**最浪费时间的不是花了 4 个小时做对了事情，而是花了 4 个小时得到了不符合需求的程序。** 为了保证正确地做事，需要先做正确的事， 在面对这种问题，最近经常使用的方式是先简化问题，然后寻找重要概念，并且绘制成一张简单的术语表，而且这个过程我还会把案例中描述的内容在脑海里演练一遍，然后不断问自己还未理解的问题：
> 例如 BowlingGame 这个案例，我会在脑海中虚拟出合适的场景，想象自己就是投保龄球那个人，包括在做什么、看到了哪些东西、可以投几轮、每轮投几次、有哪些计分规则；还会问自己一些问题，例如是投 1 次就计 1 次分，还是投完所有轮数再计分？哪种方式比较聪明、比较简单？...

然后在案例中寻找一些重要概念并记下来，这一步需要不断改进，随着对问题的理解越来越深入，就会发现更多隐喻的概念，下面是初步得到的概念：

|概念|描述|
|----|----|
|BowlingGame|保龄球游戏|
|roll| 投球|
|score|分数|

### 把事情记下来
**大脑不擅长同时处理多件事，也不擅长记住很多事情，如果发现事情不能很快完成，那么一个比较好的方式是把事情记起来，给大脑减减压，然后一个一个消灭。** 例如有些题第一次做并不简单，采用 TDD 做完经常需要几个小时，难一些的题我还断断续续做了超过一天的时间，逻辑复杂一点的题经常记不住（https://github.com/lynings/tdd-kata/blob/master/src/main/resources/merchantguidetothegalaxy/README.md ），然后又得去阅读题目，再分析，超级浪费时间。这种情况可以考虑先 tasking，拆分成小问题后一件件记下来，然后边做边调整，例如：

![](https://user-gold-cdn.xitu.io/2019/4/17/16a2a038d174652c?w=1184&h=1244&f=png&s=298467)

### 寻找新思路
**一条路走得通，只是太难走了，那换条路试试。** 之前在 code kata 时做了一遍 Args 案例，这个案例我花了很多时间在解析参数，而代码简直可以被当做反面教材，熊节老师直呼写得太丑，干了太多事。

![](https://user-gold-cdn.xitu.io/2019/4/17/16a29de6765e7b9e?w=1080&h=178&f=png&s=37815)

![](https://user-gold-cdn.xitu.io/2019/4/17/16a29e21632acf46?w=1084&h=282&f=png&s=46123)

![](https://user-gold-cdn.xitu.io/2019/4/17/16a29de1fd73bc8a?w=1080&h=2244&f=png&s=1039145)

在摸索一段时间后换了另一种思路，效率就快了很多，经过了 7 次练习，最终那道题我用了 27 分钟做完，还写了 22 个单元测试。

又例如前几天在做 Anagrams 案例的时候，分类算法花了很多时间，代码写得乱七八糟不说，运行效率也非常低下，运行了几分钟还没完成分类，只能强制关闭程序

![](https://user-gold-cdn.xitu.io/2019/4/17/16a29ea55c1ca0cf?w=1466&h=1316&f=png&s=274748)

最后换了个思路，33w+ 的单词分类只需要3秒就搞定，效率高了xxx倍，重点是代码简化了非常多。

![](https://user-gold-cdn.xitu.io/2019/4/17/16a29ed7caaebe50?w=956&h=616&f=png&s=88567)

这些事情我还可以列出很多，最后我把这种“费力不讨好”的事情总结为思路不对，对于新手来说，好的思路可能需要几个小时甚至几天才能想到，可能还需要找相关资料阅读，或者练多几遍后复盘分析，不过这是值得的，看着代码越来越简洁，编码效率越来越高，心里还是乐的。

### 小步迭代
**步伐小，思路才会清晰。**
有没有遇到过疯狂输出 5 分钟以上，一个测试还没能通过；有没有遇到写着写着前面的大部分测试都失败，然后又花了很长时间才使测试通过；有没有遇到无论怎么练，效率还是没有提高，这很可能是一下子步伐迈太大了。

例如我在练 Args 这个案例的时候，每次我都是先测试驱动出 `ArgsParser` 类 ，前 4 次至少都要一个钟以上，第 5 和第 6 次缩减到 45 分钟，因为我更专注，并且熟练了快捷键和伪代码，但是因为直接面对的问题较大，而且有越做思路越复杂的感觉，还经常影响到之前通过的测试。在复盘分析的时候，发现大部分时间是花在了思考应该怎么写逻辑上，然后我就调整了策略，先用测试驱动出 `Schema` 和 `Args` 类，因为这两个类互相独立，非常快就做好，最后再测试驱动出 `ArgsParser`，因为它依赖前面两个类，这样每一步都变得很顺畅，因为考虑的问题少了，思路清晰了很多。

### 瓶颈分析
**一道题练一遍数据样本太少，不利于分析，试着给自己定一个小目标，例如遵循 TDD，在保证质量的前提下，练到破自己或某位大神的最好记录。** 我认为瓶颈可以用时间去衡量，例如同样的问题，别人做了多久，最好成绩是多少，自己跟他的差距是多少，对别人来说那叫效率，对自己来说，那叫瓶颈，这通常需要把同一道题练多几遍，然后做复盘分析，找找自己卡在哪里的时间最长，在反馈中持续改善。
> 例如我学 TDD 经历了以下瓶颈：
>1. **缺乏 TDD 的理论知识**，自己问自己什么是 TDD 都回答不了，因此我把 Kent Beck 的《Test Driven Development》研读了好几遍，并且在 **“TDD 讨论群”** 和 **“敏捷中国史”** 这两个群中问了很多关于 TDD 的问题，很多大神给了我很多建议，真的非常感谢，并且自己还写了[TDD 原理总结](https://mp.weixin.qq.com/s/CYHshxaMtffmHms91LExnA)；
>2. **红/绿/重构的理解和习惯的养成**，因此我做了一些案例，写了几篇 TDD 实践案例文章，但是实践效果很不好。
> 3. **程序设计能力和任务拆分能力的不足**，因此我让**张逸老师**帮我推荐了一些可以提高设计能力的书给我，例如《敏捷软件开发》、《代码简洁之道》、《修改代码的艺术》、《实现模式》、《重构》等等，于是我就踏上了啃书之旅，虽然没能得到大师人物的真传，不过此时的我已经对简洁代码有了更多的理解；
> 4. **基本功太差**，机缘巧合**熊节老师**建了一个群 **“TDD和重构练功房”**，专门给一些 TDD 的爱好者练习和讨论，俗话说练武不练功，到头来一场空，在这里每天都有人在练习，有代码，有讨论，有建议，有反馈。自己在实践的过程中遇到了很多问题，例如如何减少理解题目所用的时间？任务应该如何分解？TDD 效率为什么没有提高？测试应该怎么写？从哪里测试驱动等等，这些问题在这里也慢慢有了一些感悟。

### 寻求反馈
**阻碍我们写出好代码的，首先是根本不知道代码能写多好。** 所以才需要读书（只读好书），需要练习，同时也需要反馈。把 TDD 实践的成果展示出来：哪个案例，用了多长时间，代码在哪里，看看读者能不能看懂，同时积极响应反馈，持续改善。

### 帮助他人
**怼我的人和给我建议的人我会感谢，比我经验少的人，我也会去帮助他。** 因为帮助他人会让自己思考更多自己没有遇见的问题。

### 刻意练习
> 一个小提琴家在去表演的路上迷路了，他在街角拦住了一位长者，问道：“怎么才能去卡耐基音乐厅（Carnegie Hall）”。长者看了看小提琴家，又看了他手中的琴，说道：**“你还得练，孩子，还得练！”**。

这是一个笑话，不过大部分真实情况就是那样子，你的基本功怎么样呢，**来练一个试试，往“死”里练那种。**