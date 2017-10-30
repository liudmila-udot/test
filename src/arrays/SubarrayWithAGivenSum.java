package arrays;

import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class SubarrayWithAGivenSum {

    private static class Cortege {

        private int startIndex;
        private int endIndex;

        public Cortege(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
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

        @Override
        public String toString() {
            if (startIndex == -1 || endIndex == -1) {
                return "-1";
            }

            return (startIndex + 1) + " " + (endIndex + 1);
        }
    }

    public static Cortege getSubArray(int[] input, int amount) {
        int localAmount = input[0];
        int startIndex = 0;

        if (input[0] == amount) {
            return new Cortege(0, 0);
        }

        for (int i = 1; i <= input.length - 1; i++) {
            if ((localAmount + input[i]) > amount) {
                int localWithoutStartElements = localAmount + input[i];
                int j = startIndex;
                for (; j <= i; j++) {
                    if (localWithoutStartElements > amount) {
                        localWithoutStartElements -= input[j];
                        localAmount = localWithoutStartElements;
                        startIndex = j;

                        if (localWithoutStartElements == amount) {
                            return new Cortege(j + 1, i);
                        }
                    }
                }
            } else {
                localAmount += input[i];
            }
            if (localAmount == amount) {
                return new Cortege(startIndex, i);
            }
        }

        return new Cortege(-1, -1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int arrayLength = sc.nextInt();
            int amount = sc.nextInt();
            int[] p = new int[arrayLength];
            for (int p_i = 0; p_i < p.length; p_i++) {
                p[p_i] = sc.nextInt();
            }
            System.out.println(getSubArray(p, amount));
        }
    }

}
