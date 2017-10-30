package arrays;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class RelativeSorting {

    public static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static void relativeSort(int[] a, int[] b) {
        int[] count = new int[b.length];

        for (int i = 0; i <= b.length - 1; i++) {
            for (int j = 0; j <= a.length - 1; j++) {
                if (b[i] == a[j]) {
                    count[i] = count[i] + 1;
                }
            }
        }

        int positionInA = 0;
        for (int i = 0; i <= count.length - 1; i++) {
            while (count[i] > 0) {
                for (int j = positionInA; j <= a.length - 1; j++) {
                    if (b[i] == a[j]) {
                        swap(a, positionInA, j);
                    }
                }
                count[i] = count[i] - 1;
                positionInA++;
            }
        }
        quicksort(a, positionInA, a.length -1 );

    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int pivotIndex = start - 1;

        for (int i = start; i <= end - 1; i++) {
            if (array[i] <= pivot) {
                pivotIndex++;
                swap(array, i, pivotIndex);
            }
        }
        pivotIndex++;
        swap(array, pivotIndex, end);
        return pivotIndex;
    }

    public static void quicksort(int[] array, int start, int end) {
        if (start < end) {
            int partition = partition(array, start, end);
            quicksort(array, start, partition - 1);
            quicksort(array, partition + 1, end);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int arrayALength = sc.nextInt();
            int arrayBLength = sc.nextInt();
            int[] a = new int[arrayALength];
            for (int a_i = 0; a_i < a.length; a_i++) {
                a[a_i] = sc.nextInt();
            }
            int[] b = new int[arrayBLength];
            for (int b_i = 0; b_i < b.length; b_i++) {
                b[b_i] = sc.nextInt();
            }
            relativeSort(a, b);
            System.out.println(IntStream.of(a).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        }
    }
}
