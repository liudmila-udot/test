package arrays;

import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class LeftSideSmallerRightSideGreater {

    public static int getElement(int[] array) {
        int[] maxFromLeft = new int[array.length];
        int[] minFromRight = new int[array.length];

        maxFromLeft[1] = array[0];
        for (int i = 2; i < array.length - 1; i++) {
            maxFromLeft[i] = Math.max(array[i - 1], maxFromLeft[i - 1]);
        }

        minFromRight[array.length - 2] = array[array.length - 1];
        for (int i = array.length - 3; i > 0; i--) {
            minFromRight[i] = Math.min(array[i + 1], minFromRight[i + 1]);
        }

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] >= maxFromLeft[i] && array[i] <= minFromRight[i]) {
                return array[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int[] p = new int[sc.nextInt()];
            for (int p_i = 0; p_i < p.length; p_i++) {
                p[p_i] = sc.nextInt();
            }
            System.out.println(getElement(p));
        }
    }
}
