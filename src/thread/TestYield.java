/**
 * 礼让不一定成功
 * @author: lijinhao
 * @date: 2021/12/21 19:40
 */

public class TestYield {
    public static void main(String[] args) {
        MyYield my = new MyYield();

        new Thread(my, "a").start();
        new Thread(my, "b").start();
    }
}

class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}
