package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class SortByFrequency {

    public static void sort(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.containsKey(array[i]) ? map.get(array[i]) + 1 : 1);
        }
        Map<Integer, Integer> sortedMap = map.entrySet().stream()
            .sorted(Map.Entry.<Integer, Integer>comparingByValue(
                Comparator.reverseOrder())
                .thenComparing(Map.Entry.<Integer, Integer>comparingByKey()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));

        int indexInArray = 0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            for (int i = 1; i <= entry.getValue(); i++) {
                array[indexInArray++] = entry.getKey();
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
            sort(p);
            System.out.println(Arrays.stream(p)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
        }
    }
}
