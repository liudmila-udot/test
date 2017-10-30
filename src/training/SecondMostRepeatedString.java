package training;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class SecondMostRepeatedString {

    public static String secondMostRepeated(List<String> input) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : input) {
            int count = 0;
            if (map.containsKey(str)) {
                count = map.get(str) + 1;
            }
            map.put(str, count);
        }
        LinkedHashMap<String, Integer> map2 = map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));
        Iterator<Map.Entry<String, Integer>> iterator= map2.entrySet().iterator();
        iterator.next();
        return iterator.next().getKey();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int stringCount = sc.nextInt();
            List<String> input = new ArrayList<>();
            for (int j = 1; j <= stringCount; j++) {
                input.add(sc.next());
            }
            System.out.println(secondMostRepeated(input));
        }
    }
}
