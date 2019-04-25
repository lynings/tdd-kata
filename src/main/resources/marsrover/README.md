## Mars Rover

### Your Task
You’re part of the team that explores Mars by sending remotely controlled vehicles to the surface of the planet. Develop an API that translates the commands sent from earth to instructions that are understood by the rover.

### Requirements
- You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
- The rover receives a character array of commands.
- Implement commands that move the rover forward/backward (f,b).
- Implement commands that turn the rover left/right (l,r).
- Implement wrapping from one edge of the grid to another. (planets are spheres after all)
- Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point, aborts the sequence and reports the obstacle.

### Rules
- Hardcore TDD. No Excuses!
- Change roles (driver, navigator) after each TDD cycle.
- No red phases while refactoring.
- Be careful about edge cases and exceptions. We can not afford to lose a mars rover, just because the developers overlooked a null pointer.

## 问题澄清
1. wrapping from one edge of the grid to another. (planets are spheres after all) 的意思是把 grid 当成一个球体看待（不是平面），例如向左走

## 案例分析

|术语|描述|
|----|----|
|rover|漫游者（遥控飞行器）|
|forward|向前移动|
|backward|向后移动|
|turnLeft|向左转|
|turnRight|向后转|
|startPoint|起点|
|direction|方向|
|commands|命令|
|obstacle detection|障碍物探测|
|grid|网格，地图上的坐标方格|
|square|方格，每一个小方格|
|edge|连接两个方格之间的边|
|reports|报告（漫游者用于报告障碍物）|
|aborts|终止所有动作|

## 场景设定
- 把 grid 作为一个地图的坐标系来看待，起点位置在左下角(0,0)，grid 范围由右上角的坐标来确定，例如右上角坐标为(5,5)，那么 grid 就是由 5x5=25 个 square 组成。
- grid 按上北下南左西右东来确定方向，例如 N 的朝向是 (0, 正无穷)
- rover 接收的命令格式为 FLFFRB（向前移动、向左转、向前移动、向前移动、向右转、向后移动）
- rover 在前进或者后退时如果发现障碍物，会改变移动到一个合适的 square，然后上报障碍物，并且结束所有活动.

## 初步设计
```java
class Grid {
    public Grid(Range range);
    public Grid(Range range, List<Obstacle> obstacles);
}
class ObstacleDetector {
    public ObstacleDetector(Grid grid);
    public boolean check(Square square);
}
class Rover {
    private Rover(Position initialPosition, Grid grid);
    public static Rover startup(Position position, Grid grid);
    public Position receive(Command command);
    public Position forward();
    public Position backward();
    public Position turnLeft();
    public Position turnRight();
}
```

## 任务分解
- 创建 Grid
- 增加 Grid(Range range) 构造
- 增加 Grid(Range range, List<Obstacle> obstacles) 构造
- 创建 ObstacleDetector
- 增加 ObstacleDetector(Grid grid) 构造
- 实现 obstacleDetector.check(Grid grid) 函数
- 创建 Rover
- 增加 Rover.startup(Position position, Grid grid)
- 实现 rover.forward();
- 实现 rover.backward();
- 实现 rover.turnLeft();
- 实现 rover.turnRight();
- 处理 rover.receive(command);