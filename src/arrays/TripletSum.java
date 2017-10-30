package arrays;

import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class TripletSum {
    /* This function takes last element as pivot,
      places the pivot element at its correct
      position in sorted array, and places all
      smaller (smaller than pivot) to left of
      pivot and all greater elements to right
      of pivot */
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    static void sort(int arr[]) {
        sort(arr, 0, arr.length - 1);
    }

    public static int triplet(int[] array, int sum) {

        sort(array);

        for (int i = 0; i <= array.length - 3; i++) {
            int a = array[i];
            int bIndex = i + 1;
            int cIndex = array.length - 1;

            while (bIndex < cIndex) {
                int b = array[bIndex];
                int c = array[cIndex];
                if (a + b + c == sum) {
                    return 1;
                } else if (a + b + c > sum) {
                    cIndex--;
                } else {
                    bIndex++;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int arrayLength = sc.nextInt();
            int[] p = new int[arrayLength];
            int sum =  sc.nextInt();
            for (int p_i = 0; p_i < p.length; p_i++) {
                p[p_i] = sc.nextInt();
            }
            System.out.println(triplet(p, sum));
        }
    }
}
