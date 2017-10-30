package arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class KadanesAlgorithm {

    private static class Cortege {

        private int startIndex;
        private int endIndex;
        private int amountMax;

        public Cortege(int startIndex, int endIndex, int amountMax) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.amountMax = amountMax;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }

        public int getAmountMax() {
            return amountMax;
        }

        public void setAmountMax(int amountMax) {
            this.amountMax = amountMax;
        }

        @Override
        public String toString() {
            return "Cortege{" +
                "startIndex=" + startIndex +
                ", endIndex=" + endIndex +
                ", amountMax=" + amountMax +
                '}';
        }
    }

    public static Cortege kadane(int[] input) {
        int localMax = input[0];
        int globalMax = input[0];
        int localStartIndex = 0;
        int globalStartIndex = 0;
        int globalEndIndex = 0;

        for (int i = 1; i <= input.length - 1; i++) {
            if (input[i] > localMax + input[i]){
                localStartIndex = i;
            }
            localMax = Math.max(input[i], localMax + input[i]);
            if (localMax > globalMax) {
                globalMax = localMax;
                globalStartIndex = localStartIndex;
                globalEndIndex = i;
            }
        }

        return new Cortege(globalStartIndex, globalEndIndex, globalMax);
    }

/*    public static void main(String[] args) {
        System.out.println(kadane(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}).toString());
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i<=testCases; i++){
            int[] p = new int[sc.nextInt()];
            for(int p_i = 0; p_i < p.length; p_i++){
                p[p_i] = sc.nextInt();
            }
            System.out.println(kadane(p).getAmountMax());
        }
    }
}
