import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for (int A_i = 0; A_i < n; A_i++) {
            A[A_i] = in.nextInt();
        }
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            // Write Your Code Here
            int queryType = in.nextInt();
            if (queryType == 1) {
                int i = in.nextInt();
                int j = in.nextInt();
                int x = in.nextInt();

                for (int index = i - 1; index <= j - 1; index++) {
                    A[index] = x;
                }
            } else if (queryType == 2) {
                int i = in.nextInt();
                int j = in.nextInt();
                int k = in.nextInt();
                int l = in.nextInt();
                int m = in.nextInt();

                BigInteger product1 = BigInteger.ONE;

                for (int index = i - 1; index <= j - 1; index++) {
                    product1 = product1.multiply(BigInteger.valueOf(A[index]));
                }

                BigInteger product2 = BigInteger.ONE;

                for (int index = k - 1; index <= l - 1; index++) {
                    product2 = product2.multiply(BigInteger.valueOf(A[index]));
                }

                if (product1.compareTo(product2) >= 0 && product1.mod(product2).compareTo(BigInteger.ZERO) == 0) {
                    System.out.println(product1.divide(product2).mod(BigInteger.valueOf(m)));
                } else {
                    System.out.println(-1);
                }
            }
        }
        in.close();
    }
}
