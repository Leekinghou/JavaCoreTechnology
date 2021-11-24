package v1ch08;

import com.sun.tools.javah.Gen;

import java.util.ArrayList;

/**
 * @author: lijinhao
 * @date: 2021/11/24 17:17
 */
public class test1 {
    public static void main(String[] args) {
        ArrayList<String> alph = new ArrayList<> ();
        alph.add("a");
        alph.add("b");
        alph.add("c");

        for (int i = 0; i < alph.size(); i++) {
            String s = alph.get(i);
            System.out.println(s);
        }

        Generic<Integer> strlist = new Generic<>(100);
        System.out.println(strlist.getKey());
        int key1 = strlist.getKey();
        System.out.println("key1:" + key1);

        Generic element = new Generic("abc");
        Object key2 = element.getKey();
        System.out.println(key2);

        /**
         * 泛型类不支持基本数据类型，只支持类类型
         * 因为<T>实际上在和object类型进行互相转化，
         */
        // 报错
        // Generic<int> generic1 = new Generic<int>(100);


        System.out.println("--------");
        // 同一泛型类，根据不同的数据类型创建的对象，本质上是同一个类型
        System.out.println(strlist.getClass());
        System.out.println(element.getClass());
        System.out.println(element.getClass().equals(strlist.getClass()));
        System.out.println(element.getClass().hashCode());
        System.out.println(strlist.getClass().hashCode());

        /**
         * 泛型类注意事项
         * 泛型类，如果没有指定具体的数据类型，此时，操作类型是Object
         * 泛型的类型参数只能是类类型，不能是基本数据类型
         * 泛型类型在逻辑上可以看成是多个不同的类型，但实际上都是相同类型
         */
    }
}
