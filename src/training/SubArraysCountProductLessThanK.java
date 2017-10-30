package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class SubArraysCountProductLessThanK {

    public static int subArraysCount(int[] a, int k) {
        int count = 0;
        for (int i = 0; i <= a.length - 1; i++) {
            long product = a[i];
            if (product < k) {
                count++;
            } else {
                continue;
            }
            for (int j = i + 1; j <= a.length - 1; j++) {
                product = product * a[j];
                if (product < k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static int subArraysCountSlidingWindow(int[] a, long k) {
        int count = 0;
        long windowProduct = 1;
        int left = 0;

        for (int right = 0; right <= a.length - 1; right++) {
            windowProduct = windowProduct * a[right];
            while (windowProduct >= k) {
                windowProduct = windowProduct / a[left++];
            }
            count = count + right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numT = Integer.parseInt(br.readLine().trim());
        for(int t = 0; t < numT; t++) {
            String[] line1 = br.readLine().trim().split(" ");
            int sz = Integer.parseInt(line1[0]);
            long k = Long.parseLong(line1[1]);
            String[] line = br.readLine().trim().split(" ");
            int[] p = new int[sz];
            for(int i = 0; i < sz; i++) {
                p[i] = Integer.parseInt(line[i]);
            }

            System.out.println(subArraysCountSlidingWindow(p, k));
        }
    }
}
