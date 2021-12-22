import java.util.concurrent.TimeUnit;

/**
 * @author: lijinhao
 * @date: 2021/12/22 10:21
 */

public class TestDaemon1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
           while (true){
               try{
                   TimeUnit.SECONDS.sleep(1);
                   System.out.println("I am running...");
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
           }
        });

        thread.start();

        TimeUnit.SECONDS.sleep(2);

        System.out.println("The main thread ready to exit...");

    }
}
