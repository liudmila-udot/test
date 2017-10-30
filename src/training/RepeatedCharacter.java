package training;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class RepeatedCharacter {

    public static void repeated(String s) {
        char[] a = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        boolean found = false;

        for (int i = 0; i <= a.length - 1; i++) {
            int count = 0;
            if (map.containsKey(a[i])){
                count = map.get(a[i]) + 1;
            }
            map.put(a[i], count);
        }

        for (int i = 0; i <= a.length - 1; i++) {
            if (map.get(a[i]) > 0) {
                System.out.println(a[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String s = sc.next();
            repeated(s);
        }
    }
}
