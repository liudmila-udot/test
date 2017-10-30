package arrays;

import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class TrappingRainWater {

    public static int waterAmount(int[] input) {
        int amount = 0;
        int leftBorder = input[0];
        int rightBorder = 0;
        int leftBorderIndex = 0;
        int rightBorderIndex = 0;

        for (int i = 1; i <= input.length - 1; i++) {
            if (input[i] > rightBorder) {
                rightBorderIndex = i;
            }
            rightBorder = Math.max(rightBorder, input[i]);
            if (rightBorder >= leftBorder) {
                amount = amount + (rightBorderIndex - leftBorderIndex + 1) * Math.min(leftBorder, rightBorder) - Math.min(leftBorder, rightBorder)*2;
                for (int j = leftBorderIndex + 1; j < rightBorderIndex; j++) {
                    amount = amount - input[j];
                }
                leftBorder = rightBorder;
                leftBorderIndex = rightBorderIndex;
                rightBorder = 0;
                rightBorderIndex = 0;
            }
        }

        return amount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int arrayLength = sc.nextInt();
            int[] p = new int[arrayLength];
            for (int p_i = 0; p_i < p.length; p_i++) {
                p[p_i] = sc.nextInt();
            }
            System.out.println(waterAmount(p));
        }
    }
}
