package arrays;

import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class MissingNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int[] p = new int[sc.nextInt() - 1];
            for (int p_i = 0; p_i < p.length; p_i++) {
                p[p_i] = sc.nextInt();
            }
            System.out.println(missingNumber(p));
        }
    }

    public static int missingNumber(int[] input) {
        if (input.length == 1 || input[0] + 1 != input[1]) {
            if (input[0] - 1 > 0) {
                return input[0] - 1;
            } else {
                return input[0] + 1;
            }
        }

        int min = input[0];
        int max = input[0];

        for (int i = 0; i <= input.length - 1; i++) {
            if (input[i] < min) {
                min = input[i];
            }
            if (input[i] > max) {
                max = input[i];
            }
        }

        int xorForInputArray = input[0] ^ input[1];

        for (int i = 2; i <= input.length - 1; i++) {
            xorForInputArray ^= input[i];
        }

        int xorForFullArray = min ^ max;
        int cursor = min;

        // xor for full array
        while (cursor + 1 < max) {
            cursor += 1;
            xorForFullArray ^= cursor;
        }

        int ret = xorForFullArray ^ xorForInputArray;

        if (ret != 0) {
            return ret;
        } else {
            if (min == 1) {
                return max + 1;
            } else {
                return min - 1;
            }
        }
    }
}
