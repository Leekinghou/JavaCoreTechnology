/**
 * @author: lijinhao
 * @date: 2021/12/20 20:15
 */

public class TestThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("当前事件" + i);
        }
    }

    public static void main(String[] args) {
        TestThread2 tt3 = new TestThread2();

//        Thread thread = new Thread(tt3);
//        thread.start();
        // 等同于：
        new Thread(tt3).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("=+++其他事件+++" + i);
        }
    }
}
