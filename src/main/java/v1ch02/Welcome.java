package v1ch02;

/**
 * @author: lijinhao
 * @date: 2021/11/12 12:01
 */
public class Welcome {
    public static void main(String[] args) {
        String greeting = "Welcome to Core Java!";
        System.out.println(greeting);
        for(int i = 0; i < greeting.length(); i++){
            System.out.print("=");
        }
        System.out.println();
    }
}
