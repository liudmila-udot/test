package arrays;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class StocksBuySell {

    public static int maxProfitOneTransaction(int[] array) {
        int minFromTheLeft = array[0];
        int max = 0;
        int maxSoFar;

        for (int i = 1; i <= array.length - 1; i++) {
            maxSoFar = array[i] - minFromTheLeft;
            max = Math.max(max, maxSoFar);
            minFromTheLeft = Math.min(minFromTheLeft, array[i]);
        }

        return max;
    }

    public static int maxProfitOneTransaction(int[] array, int start, int end) {
        int minFromTheLeft = array[start];
        int max = 0;
        int maxSoFar;

        for (int i = start + 1; i <= end; i++) {
            maxSoFar = array[i] - minFromTheLeft;
            max = Math.max(max, maxSoFar);
            minFromTheLeft = Math.min(minFromTheLeft, array[i]);
        }

        return max;
    }

    public static int maxProfitTwoTransactions(int[] array) {
        int max = 0;
        int maxSoFar;

        for (int i = 1; i <= array.length - 2; i++) {
            maxSoFar = maxProfitOneTransaction(array, 0, i) + maxProfitOneTransaction(array, i + 1, array.length - 1);
            max = Math.max(max, maxSoFar);
        }

        return max;
    }

    public static int maxProfitTwoTransactionsOptimized(int[] array) {
        int minFromTheLeft = array[0];

        int[] result = new int[array.length];
        int[] result2 = new int[array.length];

        for (int i = 1; i <= array.length - 1; i++) {
            result[i] = Math.max(result[i - 1], array[i] - minFromTheLeft);
            minFromTheLeft = Math.min(minFromTheLeft, array[i]);
        }

        int maxFromTheRight = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            result2[i] = Math.max(result2[i + 1], maxFromTheRight - array[i]);
            maxFromTheRight = Math.max(maxFromTheRight, array[i]);
        }

        int max = 0;

        for (int i = 1; i <= array.length - 1; i++) {
            max = Math.max(max, result[i] + result2[i]);
        }

        return max;
    }

    public static int maxProfitTwoTransactionsOptimizedVersion2(int[] array) {
        int minFromTheLeft = array[0];

        int[] result = new int[array.length];

        int maxFromTheRight = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            result[i] = Math.max(result[i + 1], maxFromTheRight - array[i]);
            maxFromTheRight = Math.max(maxFromTheRight, array[i]);
        }

        for (int i = 1; i <= array.length - 1; i++) {
            result[i] = Math.max(result[i - 1], result[i] + array[i] - minFromTheLeft);
            minFromTheLeft = Math.min(minFromTheLeft, array[i]);
        }

        return result[result.length - 1];
    }

    public static int maxProfitUnlimitedTransactions(int[] array) {
        int max = 0;
        int i = 1;
        int peak;
        int valley;

        while (i <= array.length - 1) {
            while (i <= array.length - 1 && array[i] <= array[i - 1]) {
                i++;
            }
            valley = array[i - 1];
            while (i <= array.length - 1 && array[i] >= array[i - 1]) {
                i++;
            }
            peak = array[i - 1];
            max = max + peak - valley;
        }

        return max;
    }

    static class Interval{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void printMaxProfitUnlimitedTransactions(int[] array) {
        int max = 0;
        int i = 1;
        int peak;
        int valley;
        int start;
        int end;

        List<Interval> intervals = new ArrayList<>();

        while (i <= array.length - 1) {
            while (i <= array.length - 1 && array[i] <= array[i - 1]) {
                i++;
            }
            valley = array[i - 1];
            start = i - 1;
            while (i <= array.length - 1 && array[i] >= array[i - 1]) {
                i++;
            }
            peak = array[i - 1];
            end = i - 1;
            if (start != end) {
                intervals.add(new Interval(start, end));
            }
        }
        if (!intervals.isEmpty()) {
            System.out.println(intervals.stream().map(interval -> "(" + interval.start + " " + interval.end + ")").collect(Collectors.joining(" ")));
        } else {
            System.out.print("No Profit");
        }
    }

    public static int maxProfit(int[] array, int k) {
        int[][] result = new int[k + 1][array.length];

        for (int i = 0; i <= k; i++) {
            result[i][0] = 0;
        }

        for (int i = 0; i <= array.length - 1; i++) {
            result[0][i] = 0;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= array.length - 1; j++) {
                // sell on day j, buy on day m
                int maxSoFar = 0;
                for (int m = 0; m < j; m++) {
                    maxSoFar = Math.max(maxSoFar, array[j] - array[m] + result[i - 1][m]);
                }

                result[i][j] = Math.max(result[i][j-1], maxSoFar);
            }
        }

        return result[k][array.length - 1];
    }

    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int k = sc.nextInt();
            int[] p = new int[sc.nextInt()];
            for (int p_i = 0; p_i < p.length; p_i++) {
                p[p_i] = sc.nextInt();
            }
            //System.out.println(maxProfitOneTransaction(p));
            //System.out.println(maxProfitUnlimitedTransactions(p));
            System.out.println(maxProfit(p, k));
        }*/
  /* Declare second integer, double, and String variables. */
        /* Read and save an integer, double, and String to your variables.*/
        Scanner scan = new Scanner(System.in);
        int i1 = scan.nextInt();
        double d1 = scan.nextDouble();
        scan.nextLine();
        String s1 =
            scan.nextLine();
        System.out.println(s1);
    }
}
