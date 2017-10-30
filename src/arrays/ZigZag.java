package arrays;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class ZigZag {

    public static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static void zigzag(int[] a) {
        boolean nextGreater = true;

        for (int i = 0; i < a.length - 1; i++) {
            if (nextGreater) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                }
            } else {
                if (a[i] < a[i + 1]) {
                    swap(a, i, i + 1);
                }
            }
            nextGreater = !nextGreater;
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
            zigzag(p);
            System.out.println(IntStream.of(p).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        }
    }
}
