/**
 * 放大出现问题的发生性
 * @author: lijinhao
 * @date: 2021/12/21 19:03
 */


public class TestSleep implements Runnable{
    private int ticketNums = 10;

    @Override
    public void run() {
        while(true) {
            if(ticketNums <= 0){
                break;
            }

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.getStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---> 拿到了第" + ticketNums-- + "票");
        }
    }

    public static void main(String[] args) {
        TestSleep ticket = new TestSleep();

        new Thread(ticket, "小明").start();
        new Thread(ticket, "老师").start();
        new Thread(ticket, "黄牛党").start();
    }
}
