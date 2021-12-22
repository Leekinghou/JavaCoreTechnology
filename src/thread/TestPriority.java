/**
 * Java默认的线程优先级为5，线程的执行顺序由调度程序来决定，
 * 线程的优先级会在线程被调用之前设定。
 * 通常情况下，高优先级的线程将会比低优先级的线程有更高的几率得到执行。
 * @author: lijinhao
 * @date: 2021/12/22 09:25
 */


public class TestPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "---" +
                Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        System.out.println("主线程" + "---" + Thread.currentThread().getPriority());
        TestPriority test = new TestPriority();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        Thread t3 = new Thread(test);
        Thread t4 = new Thread(test);
        t1.start();
        t2.setPriority(5);
        t2.start();
        t3.setPriority(10);
        t3.start();
        t4.setPriority(4);
        t4.start();
    }
}
