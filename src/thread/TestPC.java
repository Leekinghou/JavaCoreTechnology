/**
 * @author: lijinhao
 * @date: 2021/12/22 21:29
 */


public class TestPC {
    public static void main(String[] args) {
        Container container = new Container();
        new Productor(container).start();
        new Consumer(container).start();
    }
}


class Productor extends Thread{
    Container container;

    public Productor(Container container) {
        this.container = container;
    }

    // 生产产品
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了第 "+i+" 只鸡！");
        }
    }
}

class Consumer extends Thread{
    Container container;
    public Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了第 "+ container.pop().id+" 只鸡");
        }
    }
}

// product
class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

// 缓冲区
class Container{
    // 需要一个容器大小
    Chicken[] chickens = new Chicken[10];

    // 容器计算器
    int count = 0;

    public synchronized void push(Chicken chicken){
        //如果容器满了，需要等待消费者消费
        if(count == chickens.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果没有满，则需要丢入产品
        chickens[count] = chicken;
        count++;
        // 可以通知消费者消费
        this.notifyAll();
    }

    // 消费者消费产品
    public synchronized Chicken pop(){
        // 判断能否消费
        if(count == 0){
            // 等待生产者生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 可以开始消费
        count--;
        Chicken chicken = chickens[count];
        // 通知生产者生产
        this.notifyAll();
        return chicken;
    }
}
