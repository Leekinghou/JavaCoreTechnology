import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lijinhao
 * @date: 2021/12/22 21:01
 */

public class TestLock {
    public static void main(String[] args) {
        TestLock3 tl = new TestLock3();
        new Thread(tl).start();
        new Thread(tl).start();
        new Thread(tl).start();
    }

}

class TestLock3 implements Runnable{
    int ticketNums = 10;

    // 定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            lock.lock();  // 加锁
            try{
                if(ticketNums > 0){
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else{
                    break;
                }
            }finally {
                // 解锁
                lock.unlock();
            }

        }
    }
}
