/**
 * @author: lijinhao
 * @date: 2021/12/21 16:41
 */


public class TestStop implements Runnable{

    // 1. 设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println("run ...... Thread: " + i++);
        }

    }

    // 2. 设置一个公开的方法停止线程， 转换标志位
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop ts = new TestStop();

        new Thread(ts).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if(i == 900){
                // 调用stop方法切换标志位，让线程停止
                ts.stop();
                System.out.println("线程停止了！");
            }
        }
    }
}
