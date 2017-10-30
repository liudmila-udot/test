package arrays;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class Leader {

    public static void leader(int[] p) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer> ();
        int leader = p[p.length - 1];
        stack.push(leader);
        for (int i = p.length - 2; i >= 0; i--) {
            if (p[i] > leader) {
                leader = p[i];
                stack.push(leader);
            }
        }

        System.out.println(stack.stream().map(Object::toString).collect(Collectors.joining(" ")));
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
            leader(p);
        }
    }
}
