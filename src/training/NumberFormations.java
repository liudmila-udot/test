package training;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class NumberFormations {

    public static int sumAllCombinations(int x, int y, int z){
        List<Integer> combinations = new ArrayList<>();

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            Integer x = sc.nextInt();
            Integer y = sc.nextInt();
            Integer z = sc.nextInt();
            System.out.println(sumAllCombinations(x, y, z));
        }
    }
}
