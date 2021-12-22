/**
 * @author: lijinhao
 * @date: 2021/12/20 19:29
 */

public class TestThread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("当前事件" + i);
        }

    }

    public static void main(String[] args) {
        TestThread1 tt = new TestThread1();

        tt.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("=+++其他事件+++" + i);
        }
    }
}
