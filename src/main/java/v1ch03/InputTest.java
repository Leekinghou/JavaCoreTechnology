package v1ch03;

import java.util.Scanner;

/**
 * @author: lijinhao
 * @date: 2021/10/28 00:11
 */
public class InputTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("What is your name?");
        String name = in.nextLine();

        System.out.print("How old are you?");
        int age = in.nextInt();

        System.out.println("Hello, " + name + ". Next year, you will be "+ (age + 1));
    }
}
