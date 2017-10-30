package training;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class ExcelColumn {

    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String column(Integer number) {

        String ret = "";

        while (number > 0) {
            int remainder = number % 26;

            if (remainder == 0) {
                ret = "Z" + ret;
            } else {
                ret = alphabet.charAt(remainder - 1) + ret;
            }

            number = (number - 1)/ 26;
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            Integer number = sc.nextInt();
            System.out.println(column(number));
        }
    }
}
