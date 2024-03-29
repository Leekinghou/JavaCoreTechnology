import java.util.ArrayList;
import java.util.List;

/**
 * @author: lijinhao
 * @date: 2021/12/22 17:05
 */


public class SafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            new Thread(() ->{
               synchronized (list){
                   list.add(Thread.currentThread().getName());
               }
            }).start();
        }
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
