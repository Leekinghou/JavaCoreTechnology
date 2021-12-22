/**
 * @author: lijinhao
 * @date: 2021/12/22 18:09
 */

public class DeadLock {
    public static void main(String[] args) {
        Makeup girl1 = new Makeup(0, "mary");
        Makeup girl2 = new Makeup(1, "daisy");

        girl1.start();
        girl2.start();
    }
}

class Makeup extends Thread{
    // 需要的资源只有一份，用static来保证
    static LipStick lipstick = new LipStick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;

    Makeup(int choice, String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 化妆， 互相持有对方的锁，就是需要拿到对方的资源
    private void makeup() throws InterruptedException{
        if(choice == 0){
            synchronized (lipstick){
                System.out.println(this.girlName + " get lipstick's lock");
                Thread.sleep(1000);
            }
            // 一秒后想获得镜子
            synchronized (mirror){
                System.out.println(this.girlName + " get mirror's lock");
            }
        }else {
            synchronized (mirror) {
                System.out.println(this.girlName + " get mirror's lock");
                Thread.sleep(1000);
            }
            // 一秒后想获得口红
            synchronized (lipstick) {
                System.out.println(this.girlName + " get lipstick's lock");
            }
        }
    }
}

class Mirror{

}

class LipStick{

}
