/**
 * @author: lijinhao
 * @date: 2021/12/22 09:36
 */


public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        Human human = new Human();
        Thread thread = new Thread(god);

        thread.setDaemon(true);
        thread.start();
        new Thread(human).start();
    }
}

class God implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("God bless you!");
        }
    }
}

class Human implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Happy every day!");
        }
        System.out.println("leave forever");
    }
}

