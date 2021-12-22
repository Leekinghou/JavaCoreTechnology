/**
 * 层层简化，逐步递进优化
 * @author: lijinhao
 * @date: 2021/12/20 22:10
 */


public class TestLambda1 {

    // 3. 静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I like lambda2!");
        }
    }

    static class Like implements ILike{
        @Override
        public void lambda() {
            System.out.println("I like lambda!");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        // 4. 局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I like lambda3!");
            }
        }

        like = new Like3();
        like.lambda();

        // 5. 匿名内部类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4!");
            }
        };
        like.lambda();

        // 6. lambda简化
        like = () -> System.out.println("I like lambda5!");
        like.lambda();

        // 其他
//        ILove love = (int name) -> System.out.println("I love " + name);

        ILove love = null;
        love = (name) -> System.out.println("I love " + name);
        love.love(123);

    }
}

// 1. 定义一个函数式接口
interface ILike{
    void lambda();
}

// 其他
interface ILove{
    void love(int name);
}


// 2. 实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("I like lambda!");
    }
}

