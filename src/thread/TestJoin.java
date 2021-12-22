/**
 * @author: lijinhao
 * @date: 2021/12/21 20:04
 */


public class TestJoin implements Runnable{


    public static void main(String[] args) throws InterruptedException {
        TestJoin tj = new TestJoin();

        Thread thread = new Thread(tj);
        thread.start();

        // 主线程
        for (int i = 0; i < 1000; i++) {
            if(i == 800){
                thread.join();
                System.out.println("main..." + i);
            }
        }
    }

    // vip插入
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("join vip！！！！..." + i);
        }
    }
}
