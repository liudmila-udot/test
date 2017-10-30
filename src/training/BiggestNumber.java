package training;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class BiggestNumber {

    public static Comparator<Integer> customComparator = (e1, e2) ->
        Integer.compare(
        Integer.parseInt(e1.toString() + e2.toString()),
        Integer.parseInt(e2.toString() + e1.toString())
        );

    public static String biggestNumber(int[] a) {
        return IntStream.of(a)
            .boxed()
            .sorted(customComparator.reversed())
            .map(Object::toString)
            .collect(Collectors.joining());
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
            System.out.println(biggestNumber(p));
        }
    }
}
