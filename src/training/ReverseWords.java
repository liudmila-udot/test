package training;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class ReverseWords {

    public static String reverse(String s) {
        String[] arr = s.split("\\.");
        String[] newArr = new String[arr.length];

        for (int i = 0; i <= arr.length - 1; i++) {
            newArr[arr.length -1 - i] = arr[i];
        }

        return Stream.of(newArr).collect(Collectors.joining("."));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String s = sc.next();
            System.out.println(reverse(s));
        }
    }
}
