package arrays;

import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class EqualSumAndProduct {

    public static int count(int[] a) {
        int count = 0;
        int amount;
        int product;
        for (int i = 0; i <= a.length - 1; i++) {
            amount = a[i];
            product = a[i];
            for (int j = i + 1; j <= a.length - 1; j++) {
                if (amount == product) {
                    count++;
                }
                amount = amount + a[j];
                product = product * a[j];
            }
            if (amount == product) {
                count++;
            }
        }
        return count;
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
            System.out.println(count(p));
        }
    }
}
