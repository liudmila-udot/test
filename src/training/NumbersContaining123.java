package training;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class NumbersContaining123 {

    public static List<Integer> findNumbers(int[] arr) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i <= arr.length - 1; i++) {
            if (isContainsOnly123(arr[i])) {
                ret.add(arr[i]);
            }
        }

        return ret;
    }

    public static boolean isContainsOnly123(int a) {
        while (a != 0) {

            int temp = a % 10;

            if (!(temp == 1 || temp == 2 || temp == 3)) {
                return false;
            }
            a = a / 10;
        }

        return true;
    }

    public static boolean isContainsOnlyDigit(int toCheck, int digit) {

        while (toCheck != 0) {

            int temp = toCheck % 10;

            if (!((temp / digit) == 1 && (temp % digit) == 0)) {
                return false;
            }
            toCheck = toCheck / 10;
        }

        return true;
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
            List<Integer> ret = findNumbers(p);

            System.out.println(!ret.isEmpty() ?
                findNumbers(p).stream()
                    .sorted(Comparator.reverseOrder())
                    .map(Object::toString)
                    .collect(Collectors.joining(" ")) :
                -1);
        }
    }
}
