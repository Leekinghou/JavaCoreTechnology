package knowledge1.reflect;

/**
 * @author: lijinhao
 * @date: 2022/01/19 15:29
 */
public class Subtraction implements MathOperation{

    @Override
    public int operate(int a, int b) {
        return a - b;
    }
}
