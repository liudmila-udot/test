package training;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class EqualArrays {

    public static boolean equalArrays(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i <= a.length - 1; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
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
            int[] t = new int[arrayLength];
            for (int t_i = 0; t_i < t.length; t_i++) {
                t[t_i] = sc.nextInt();
            }
            boolean equal = equalArrays(p, t);
            System.out.println(equal ? 1 : 0);
        }
    }
}
