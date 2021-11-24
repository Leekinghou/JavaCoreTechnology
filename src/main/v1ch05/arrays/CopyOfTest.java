package v1ch05.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: lijinhao
 * @date: 2021/11/15 21:51
 */
public class CopyOfTest {
    public static void main(String[] args) {
        int[] a= {1, 2, 3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = { "Tom", "Dick", "Harry" };
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));

        System.out.println("The following call will generate an exception.");
        b = (String[]) badCopyOf(b, 10);
    }

    public static Object[] badCopyOf(Object[] a, int newLength){
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }

    public static Object goodCopyOf(Object a, int newLength){
        Class cl = a.getClass();
        if(!cl.isArray()) return null;
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a,0, newArray, 0, Math.min(length, newLength));
        /*
        *  public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)

            src:源数组;

            srcPos:源数组要复制的起始位置;

            dest:目的数组;

            destPos:目的数组放置的起始位置;

            length:复制的长度.

           * */
        return newArray;
    }
}
