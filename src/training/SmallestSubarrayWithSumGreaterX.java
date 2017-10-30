package training;

import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class SmallestSubarrayWithSumGreaterX {

    public static int smallestSubArray(int[] a, int x) {
        int windowSum = 0;
        int start = 0;
        int smallestLength = 0;

        for (int end = 0; end <= a.length - 1; end++) {
            windowSum += a[end];
            while (windowSum > x) {
                if (windowSum > x) {
                    if (smallestLength > 0) {
                        smallestLength = Math.min(smallestLength, end - start + 1);
                    } else {
                        smallestLength = end - start + 1;
                    }
                }
                windowSum = windowSum - a[start++];
            }
        }

        return smallestLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int arrayLength = sc.nextInt();
            int x = sc.nextInt();
            int[] p = new int[arrayLength];
            for (int p_i = 0; p_i < p.length; p_i++) {
                p[p_i] = sc.nextInt();
            }
            System.out.println(smallestSubArray(p, x));
        }
    }
}
