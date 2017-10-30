package arrays;

import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class SpirallyTraverseMatrix {

    public static int[] spiral(int[][] a){
        int[] ret = new int[a[0].length];
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int arrayLength = 4;
            int[][] p = new int[arrayLength][arrayLength];
            for (int p_i = 0; p_i < p.length; p_i++) {
                //p[p_i] = sc.nextInt();
            }
            System.out.println(spiral(p));
        }
    }
}
