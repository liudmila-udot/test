package arrays;

import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class MinimumPlatforms {

    public static int platforms(int[] arrive, int[] leave) {
        int max = 0;
        int maxSoFar = 0;
        for (int i = 0; i <= arrive.length - 1; i++) {
            for (int j = 0; j <= arrive.length - 1; j++) {
                if (i != j) {
                   // if ()_
                }
            }
        }
        return max + 1;
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
            int[] n = new int[arrayLength];
            for (int p_i = 0; p_i < n.length; p_i++) {
                n[p_i] = sc.nextInt();
            }
            System.out.println(platforms(p, n));
        }
    }
}
