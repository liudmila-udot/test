import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class Solution2 {

    static int min;

    public static int dfs(int n) {
        vis[n] = true;
        int children = 1;
        for (int i = 0; i < adj[n].size(); i++) {
            if (!vis[adj[n].get(i)]) {
                children += dfs(adj[n].get(i));
            }
        }
        if (s[n] == 0 && children < min) {
            min = children;
        }
        return children;
    }

    static int[] s;
    static boolean[] vis;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int dRooms = 0;
            s = new int[n];
            adj = new ArrayList[n];
            for (int s_i = 0; s_i < n; s_i++) {
                s[s_i] = in.nextInt();
                if (s[s_i] == 0) {
                    dRooms++;
                }
                adj[s_i] = new ArrayList<>();
            }
            for (int a1 = 0; a1 < n - 1; a1++) {
                int a = in.nextInt();
                int b = in.nextInt();
                adj[a - 1].add(b - 1);
                adj[b - 1].add(a - 1);
            }
            for (int i = 0; i < n; i++) {
                vis = new boolean[n];
                if (dRooms % 2 == 0) {
                    System.out.println(n);
                } else {
                    min = Integer.MAX_VALUE;
                    dfs(i);
                    System.out.println(n - min);
                }
            }
        }
        in.close();
    }
}
