package v1ch03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: lijinhao
 * @date: 2021/11/12 21:29
 */
public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);

        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.print("What is the highest number you can draw? ");
        int n = in.nextInt();

        int[] numebrs = new int[n];
        for (int i = 0; i < numebrs.length; i++) {
            numebrs[i] = i + 1;
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            int r = (int) (Math.random() * n);

            result[i] = numebrs[r];

            numebrs[r] = numebrs[n - 1];
            n--;
        }
        Arrays.sort(result);
        System.out.println("Bet the following combination. It'll make you rich!");
        for(int r: result){
            System.out.println(r);
        }
    }



}
