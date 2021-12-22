/**
 *      * 代理对象可以做很多真实对象无法完成的事情
 *      * 真实对象专注于自己的事情
 * @author: lijinhao
 * @date: 2021/12/20 21:49
 */



public class StaticProxy {

    public static void main(String[] args) {
//        You you = new You();
//        you.HappyMarry();


        WeddingCompany wc = new WeddingCompany(new You());
        wc.HappyMarry();
    }

}

interface Marry{
    void HappyMarry();
}

class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("you get married!");
    }
}

class WeddingCompany implements Marry{
    private  Marry target;

    public WeddingCompany(Marry target){
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("收尾款，给好评");
    }

    private void before() {
        System.out.println("收尾款，给好评");
    }
}
