/**
 * @author: lijinhao
 * @date: 2021/12/22 16:08
 */

public class SafeBuyTicket implements Runnable{
    private int ticketNums = 10;
    boolean flag = true;  // 外部停止方式

    @Override
    public void run() {
        // 买票
        while(flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    // synchronized 同步方法，锁的是this
    public synchronized void buy() throws InterruptedException {
        if(ticketNums <= 0){
            flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "买到第"+ ticketNums-- + "张票");

    }

    public static void main(String[] args) {
        SafeBuyTicket ticket = new SafeBuyTicket();

        new Thread(ticket, "老人").start();
        new Thread(ticket, "小孩").start();
        new Thread(ticket, "黄牛党").start();
    }
}
