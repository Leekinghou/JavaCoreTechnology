import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author: lijinhao
 * @date: 2021/12/22 10:27
 */

public class TestDaemon2 {
    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime()
                .addShutdownHook(new Thread(() -> System.out.println("The JVM exit success")));
        Thread thread = new Thread(() -> {
           while(true){
               try {
                   TimeUnit.SECONDS.sleep(1);
                   System.out.println("I am running...");
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
           }
        });

        thread.setDaemon(true);
        thread.start();

        TimeUnit.SECONDS.sleep(2);
        System.out.println("The main thread ready to exit...");
    }
}
