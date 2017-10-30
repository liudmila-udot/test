package arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class ThreeWayPartition {

    public static void partition(int[] input) {

        int cursor = 0;
        int start = 0;
        int end = input.length - 1;
        int pivot = 1;
        int temp = 0;

        while (cursor <= end) {
            if (input[cursor] < pivot) {
                temp = input[start];
                input[start] = input[cursor];
                input[cursor] = temp;
                start++;
                cursor++;
            } else if (input[cursor] > pivot) {
                temp = input[end];
                input[end] = input[cursor];
                input[cursor] = temp;
                end--;
            } else {
                cursor++;
            }
        }
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
            partition(p);
            System.out.println(Arrays.stream(p)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
        }
    }
}
