/**
 * @author: lijinhao
 * @date: 2021/12/22 16:21
 */

public class SafeDrawMoney{
    public static void main(String[] args) {
        Account account = new Account(100, "旅行基金");

        Drawing you = new Drawing(account, 50,"你");
        Drawing gf = new Drawing(account, 100, "你老婆");

        you.start();
        gf.start();
    }
}

class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread{
    // 账户
    Account account;
    // 取了多少钱
    int drawingMoney;
    // 手里还有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        // 需要增删改的对象
        synchronized (account){
            if(account.money - drawingMoney < 0){
                System.out.println(Thread.currentThread().getName()+"余额不足");
                return;
            }
            // 卡内余额 = 余额 - 你取的钱
            account.money = account.money - drawingMoney;

            // 手里的钱
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name+"余额为：" + account.money);

            // Thread.currentThread().getName() = this.getName()
            System.out.println(this.getName() + "手里的钱:" + account.money);
        }
    }
}
