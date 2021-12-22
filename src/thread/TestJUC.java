import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: lijinhao
 * @date: 2021/12/22 17:52
 */


public class TestJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
               list.add(Thread.currentThread().getName());
            }).start();
        }
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
