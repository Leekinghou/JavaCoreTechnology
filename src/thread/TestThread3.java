/**
 * @author: lijinhao
 * @date: 2021/12/20 20:37
 */


public class TestThread3 implements Runnable{

    private int ticketNums = 10;


    @Override
    public void run() {
        while(true){
            if(ticketNums <= 0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---> get ticket:" + ticketNums--);
        }
    }

    public static void main(String[] args) {
        TestThread3 ticket = new TestThread3();

        new Thread(ticket, "java").start();
        new Thread(ticket, "python").start();
        new Thread(ticket, "C++").start();
    }
}
