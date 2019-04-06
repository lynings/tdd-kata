## Bowling Game
The game consists of 10 frames as shown above.  In each frame the player has
two opportunities to knock down 10 pins.  The score for the frame is the total
number of pins knocked down, plus bonuses for strikes and spares.

A spare is when the player knocks down all 10 pins in two tries.  The bonus for
that frame is the number of pins knocked down by the next roll.  So in frame 3
above, the score is 10 (the total number knocked down) plus a bonus of 5 (the
number of pins knocked down on the next roll.)

A strike is when the player knocks down all 10 pins on his first try.  The bonus
for that frame is the value of the next two balls rolled.

In the tenth frame a player who rolls a spare or strike is allowed to roll the extra
balls to complete the frame.  However no more than three balls can be rolled in
tenth frame.

## The Requirements.
Write a class named “Game” that has two methods
- roll(pins : int) is called each time the player rolls a ball.  The argument is the number of pins knocked down.
- score() : int is called only at the very end of the game.  It returns the total score for that game.

## 案例分析
- bowling game 总共进行10轮。
- 每轮有两次机会和10个保龄球，击中1个保龄球记1分。
- 在一轮中的第一次投球就击中10球，称之为"strike"，记 10 分，并且还奖励接下来两次投球的分数。
- 在一轮中的通过两次投球才击中10球，称之为"spare"，记 10 分，并且还奖励接下一轮游戏中的第一次投球的分数。
- 在一轮中的通过两次投球未能击中10球，称之为"miss"，记两个投球的分数的累加，无奖励分。
- 第十轮最多投三次球，如果第一次全中，则可以继续投多两次；如果第二次总共得10分，则可以继续投多一次；如果投两次未能全部击中，则比赛结束（不包括上面规则的奖励）。

## 任务分解
- [x] 验证10轮都投不中的分数为0；
- [x] 验证每轮都投中9球的分数为 90 分。
- [x] 验证每轮第一次就投中10球的分数为 300 分。
- [ ] 验证每轮第一次击中5球，第二次投中5球，并且最后一轮第三次投中10球的分数为 160 分。
