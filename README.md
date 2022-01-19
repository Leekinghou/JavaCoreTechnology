# JavaCoreTechnology

《Java核心技术》课后练习题

[博客: 代码笔记](https://lijinhao.site/2021/12/21/Java%E5%A4%9A%E7%BA%BF%E7%A8%8B/)

以及【Knowledge系列】学习java反射的笔记
- [knowledge1](#knowledge1) 反射Reflect
# Thread
- Thread类和Runnable接口实现多线程的区别
- Runnable 接口
- 龟兔赛跑 
  - 多个线程，操作一个对象
- 静态代理
- lambda 表达式优化代码
- 线程停止
- 线程休眠
- yield
- 线程强制执行 join 
- 观察线程状态
- 线程的优先级
- 守护线程 daemon
- 守护进程的方法
  - 钩子进程
- 线程同步
  - 锁方法
  - 锁变量
  - 锁集合
    - CopyOnWriteArrayList
- 死锁
  - 会产生死锁的情况
  - 消除死锁的情况
- Lock锁
  - Synchronized与Lock的对比
- 线程协作
  - 生产者消费者问题
    - 管程法
    - 信号灯法
  - 线程池


# knowledge1
## 学习要点
- 反射及其作用
- 反射的四个核心类
- 反射在项目中的作用

## 什么是反射
**反射（reflect）是代码`在运行时`动态访问类与对象的技术**
- 来自于`java.lang.reflect`  
  初学java时，要实例化一个对象，需要：
```java
Object obj = new Object<>();
```
这个步骤在程序编译时运行。

## 反射的作用
大多数java框架都基于反射实现参数配置、动态注入等特性
