import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class GraphSolution {

    static class Graph {

        int vertexCount;
        Map<Integer, List<Integer>> adj; // Adjacency list

        Graph(int vertexCount) {
            this.vertexCount = vertexCount;
            adj = new HashMap<Integer, List<Integer>>();
        }

        void addEdge(int u, int v) {
            if (!adj.containsKey(u)) {
                adj.put(u, new ArrayList<Integer>());
            }
            if (!adj.containsKey(v)) {
                adj.put(v, new ArrayList<Integer>());
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<List<Integer>> getAllPaths(int u, int v) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if (u == v) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(u);
                result.add(temp);
                return result;
            }
            boolean[] visited = new boolean[vertexCount];
            Deque<Integer> path = new ArrayDeque<Integer>();
            getAllPathsDFS(u, v, visited, path, result);
            return result;
        }

        void getAllPathsDFS(int u, int v, boolean[] visited, Deque<Integer> path, List<List<Integer>> result) {
            visited[u] = true; // Mark visited
            path.add(u); // Add to the end
            if (u == v) {
                result.add(new ArrayList<Integer>(path));
            } else {
                if (adj.containsKey(u)) {
                    for (Integer i : adj.get(u)) {
                        if (!visited[i]) {
                            getAllPathsDFS(i, v, visited, path, result);
                        }
                    }
                }
            }
            path.removeLast();
            visited[u] = false;
        }

        // A utility function to print the adjacency list
        // representation of graph
        void printGraph() {
            for (int v = 1; v <= vertexCount; v++) {
                System.out.println("Adjacency list of vertex " + v);
                for (Integer pCrawl : adj.get(v)) {
                    System.out.print(" -> " + pCrawl);
                }
                System.out.println("\n");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int[] s = new int[n];
            for (int s_i = 0; s_i < n; s_i++) {
                s[s_i] = in.nextInt();
            }

            Graph graph = new Graph(n);

            for (int a1 = 0; a1 < n - 1; a1++) {
                int a = in.nextInt();
                int b = in.nextInt();

                graph.addEdge(a, b);
            }
            graph.printGraph();
            graph.getAllPaths(1,2);
        }
        in.close();
    }
}
