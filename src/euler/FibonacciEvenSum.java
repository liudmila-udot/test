package euler;

import java.math.BigInteger;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class FibonacciEvenSum {

    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 0;

        BigInteger amount = BigInteger.ZERO;

        while (c <= 4000000){
          c = genFibonacci(a, b);
          if (c <= 4000000 && c % 2 == 0){
              amount = amount.add(BigInteger.valueOf(c));
          }
          a = b;
          b = c;
        }

        System.out.println(amount);
    }

    public static int genFibonacci(int a, int b) {
        return a + b;
    }

}
