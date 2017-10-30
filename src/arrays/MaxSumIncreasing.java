package arrays;

import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class MaxSumIncreasing {

    public static int maxAmountRecursive(int[] input, int i, int prev, int amount) {
        if (i == input.length){
            return amount;
        }

        int newAmount = maxAmountRecursive(input, i+1, prev, amount);
        int addAmount = 0;
        if (input[i] > prev) {
            addAmount = maxAmountRecursive(input, i+1, input[i], input[i] + amount);
        }

        return Math.max(newAmount, addAmount);
    }

    public static int maxAmount(int[] input) {
        int globalAmount = input[0];
        for (int i = 0; i <= input.length - 1; i++) {
            int localAmount = input[i];
            int previous = input[i];
            if (i < input.length - 1) {
                for (int j = i + 1; j <= input.length - 1; j++) {
                    if (input[j] >= previous) {
                        localAmount += input[j];
                        previous = input[j];
                    }
                }
            }
            if (localAmount > globalAmount) {
                globalAmount = localAmount;
            }
        }

        return globalAmount;
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
            //System.out.println(maxAmount(p));
            System.out.println(maxAmountRecursive(p, 0, p[0], p[0]));
        }
    }
}
