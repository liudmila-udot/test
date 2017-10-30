package arrays;

import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class SingleElement {

    public static int singleElement(int[] a) {
        int i = 0;
        while (i < a.length - 1) {
            if (a[i] == a[i + 1]) {
                i = i + 2;
            } else {
                return a[i];
            }
        }

        return a[a.length - 1];
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
            System.out.println(singleElement(p));
        }
    }
}
