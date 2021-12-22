/**
 * @author: lijinhao
 * @date: 2021/12/21 21:19
 */


public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            // 睡5秒
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("///////////");
        });

        Thread.State state = thread.getState();
        System.out.println(state);

        thread.start();
        state = thread.getState();
        System.out.println(state);

        while(state != Thread.State.TERMINATED){
            Thread.sleep(100);
            state = thread.getState();  // 更新线程状态
            System.out.println(state);  // 输出状态
        }
    }
}
