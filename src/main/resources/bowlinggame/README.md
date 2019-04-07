## Bowling Game
Write a program to score a game of Ten-Pin Bowling.

Input: string (described below) representing a bowling game
Ouput: integer score

The scoring rules:

Each game, or "line" of bowling, includes ten turns, 
or "frames" for the bowler.

In each frame, the bowler gets up to two tries to 
knock down all ten pins.

If the first ball in a frame knocks down all ten pins,
this is called a "strike". The frame is over. The score 
for the frame is ten plus the total of the pins knocked 
down in the next two balls.

If the second ball in a frame knocks down all ten pins, 
this is called a "spare". The frame is over. The score 
for the frame is ten plus the number of pins knocked 
down in the next ball.

If, after both balls, there is still at least one of the
ten pins standing the score for that frame is simply
the total number of pins knocked down in those two balls.

If you get a spare in the last (10th) frame you get one 
more bonus ball. If you get a strike in the last (10th) 
frame you get two more bonus balls.
These bonus throws are taken as part of the same turn. 
If a bonus ball knocks down all the pins, the process 
does not repeat. The bonus balls are only used to 
calculate the score of the final frame.

The game score is the total of all frame scores.

Examples:

'X' indicates a strike

'/' indicates a spare

'-' indicates a miss

'|' indicates a frame boundary

The characters after the || indicate bonus balls

X|X|X|X|X|X|X|X|X|X||XX
Ten strikes on the first ball of all ten frames.
Two bonus balls, both strikes.
Score for each frame == 10 + score for next two 
balls == 10 + 10 + 10 == 30
Total score == 10 frames x 30 == 300

9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||
Nine pins hit on the first ball of all ten frames.
Second ball of each frame misses last remaining pin.
No bonus balls.
Score for each frame == 9
Total score == 10 frames x 9 == 90

5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5
Five pins on the first ball of all ten frames.
Second ball of each frame hits all five remaining
pins, a spare.
One bonus ball, hits five pins.
Score for each frame == 10 + score for next one
ball == 10 + 5 == 15
Total score == 10 frames x 15 == 150

X|7/|9-|X|-8|8/|-6|X|X|X||81
Total score == 167

## 案例分析
- bowling game 总共进行10轮。
- 每轮有两次机会和10个保龄球，击中1个保龄球记1分。
- 在一轮中的第一次投球就击中10球，称之为"strike"，记 10 分，并且还奖励接下来两次投球的分数。
- 在一轮中的通过两次投球才击中10球，称之为"spare"，记 10 分，并且还奖励接下一轮游戏中的第一次投球的分数。
- 在一轮中的通过两次投球未能击中10球，记两个投球的分数的累加，无奖励分。
- 第十轮最多投三次球，如果第一次全中，则可以继续投多两次；如果前二次总击球数为10，则可以继续投多一次；如果前两次未能击中10球，则比赛结束。

## 任务分解
- [x] 验证10轮都投不中的分数为0；
- [x] 验证每轮都投中9球的分数为 90 分。
- [x] 验证每轮第一次就投中10球的分数为 300 分。
- [x] 验证每轮第一次击中5球，第二次投中5球，并且最后一轮第三次投中10球的分数为 155 分。
- [x] 重构获取分数任务