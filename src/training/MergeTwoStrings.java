package training;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class MergeTwoStrings {

    public static String merge(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        char[] ret = new char[arr1.length + arr2.length];

        int index = 0;
        int retIndex = 0;

        while (retIndex <= ret.length - 1){
            if (index <= arr1.length -1){
                ret[retIndex++] = arr1[index];
            }
            if (index <= arr2.length -1){
                ret[retIndex++] = arr2[index];
            }
            index++;
        }
        return String.valueOf(ret);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(merge(s1, s2));
        }
    }
}
