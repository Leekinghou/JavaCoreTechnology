package v1ch06.clone;

/**
 * @author: lijinhao
 * @date: 2021/11/24 15:32
 * clone() 是 Object 的 protected 方法，它不是 public，
 * 一个类不显式去重写 clone()，其它类就不能直接去调用该类实例的 clone() 方法。
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee original = new Employee("John Q. Public", 50000);
        original.setHireDay(2000, 1, 1);
        Employee copy = original.clone();
        copy.raiseSalary(10);
        copy.setHireDay(2002, 12, 31);
        System.out.println("original=" + original);
        System.out.println("copy=" + copy);
    }
}
