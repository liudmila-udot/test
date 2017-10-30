package arrays;

import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class EquilibriumPoint {

    public static int equilibrium(int[] input) {
        if (input.length == 1) {
            return 1;
        }
        if (input.length == 2) {
            return -1;
        }

        int amountRight = 0;
        for (int i = 2; i <= input.length - 1; i++) {
            amountRight += input[i];
        }
        int amountLeft = input[0];
        for (int i = 1; i < input.length - 1; i++) {
            if (amountLeft == amountRight) {
                return i + 1;
            }
            amountLeft += input[i];
            amountRight -= input[i + 1];
        }
        return -1;
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
            System.out.println(equilibrium(p));
        }
    }

}
