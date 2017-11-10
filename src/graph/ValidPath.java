package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class ValidPath {

    static class Field {

        int x;
        int y;

        public Field(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            final Field field = (Field) o;

            if (x != field.x) {
                return false;
            }
            return y == field.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    static class Graph {

        Map<Field, List<Field>> adj; // Adjacency list

        Graph(int maxX, int maxY) {
            adj = new HashMap<Field, List<Field>>();

            for (int i = 1; i <= maxX; i++) {
                for (int j = 1; j <= maxX; j++) {
                    Field field = new Field(i, j);

                    // right field
                    if (i + 1 <= maxX) {
                        addEdge(field, new Field(i + 1, j));
                        // diagonal
                        if (j - 1 >= 1) {
                            addEdge(field, new Field(i + 1, j - 1));
                        }
                    }
                    // diagonal
                    if (j - 1 >= 1) {
                        addEdge(field, new Field(i, j - 1));
                        if (i - 1 >= 1) {
                            addEdge(field, new Field(i - 1, j - 1));
                        }
                    }
                    if (i - 1 >= 1) {
                        addEdge(field, new Field(i - 1, j));
                        if (j + 1 <= maxY) {
                            addEdge(field, new Field(i - 1, j + 1));
                        }
                    }
                    if (j + 1 <= maxY) {
                        addEdge(field, new Field(i, j + 1));
                        if (i + 1 <= maxX) {
                            addEdge(field, new Field(i + 1, j + 1));
                        }
                    }
                }
            }
        }

        void addEdge(Field one, Field two) {
            if (!adj.containsKey(one)) {
                adj.put(one, new ArrayList<Field>());
            }
            if (!adj.containsKey(two)) {
                adj.put(two, new ArrayList<Field>());
            }
            adj.get(one).add(two);
            adj.get(two).add(one);
        }

        void removeEdge(Field field) {
            adj.remove(field);
            for (Map.Entry<Field, List<Field>> entry : adj.entrySet()) {
                entry.getValue().remove(field);
            }
        }
    }

    public static void dfs(Graph graph) {
        LinkedList s = new LinkedList();
        Set<Field> visited = new HashSet<>();

        Field rootNode = new Field(1, 1);

        s.push(rootNode);
        visited.add(rootNode);
        System.out.println("x: " + rootNode.x + ", y: " + rootNode.y);
        while (!s.isEmpty()) {
            Field n = (Field) s.peek();
            Field child = getUnvisitedChildNode(graph, n, visited);  // Essentially this function goes through the neighbors of n, and finds the one with node.visited = false
            if (child != null) {
                visited.add(child);
                System.out.println("x: " + child.x + ", y: " + child.y);
                s.push(child);
            } else {
                s.pop();
            }
        }
    }

    public static void bfs(Graph graph) {
        //BFS uses Queue data structure
        LinkedList q = new LinkedList();
        Set<Field> visited = new HashSet<>();

        Field rootNode = new Field(1, 1);

        q.add(rootNode);
        System.out.println("x: " + rootNode.x + ", y: " + rootNode.y);
        visited.add(rootNode);

        while (!q.isEmpty()) {
            Field n = (Field) q.remove();
            Field child = null;
            while ((child = getUnvisitedChildNode(graph, n, visited)) != null) {
                visited.add(child);
                System.out.println("x: " + child.x + ", y: " + child.y);
                q.add(child);
            }
        }
        //Clear visited property of nodes
    }

    public static boolean bfs(Graph graph, Field toFind) {
        //BFS uses Queue data structure
        LinkedList q = new LinkedList();
        Set<Field> visited = new HashSet<>();

        Field rootNode = new Field(1, 1);

        q.add(rootNode);
        //System.out.println("x: " + rootNode.x + ", y: " + rootNode.y);
        visited.add(rootNode);

        while (!q.isEmpty()) {
            Field n = (Field) q.remove();
            Field child = null;
            while ((child = getUnvisitedChildNode(graph, n, visited)) != null) {
                visited.add(child);
                //System.out.println("x: " + child.x + ", y: " + child.y);
                q.add(child);
                if (child.equals(toFind)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Field getUnvisitedChildNode(Graph graph, Field n, Set<Field> visited) {
        if (graph.adj.get(n) != null) {
            Set<Field> unvisited = new HashSet<>(graph.adj.get(n));
            unvisited.removeAll(visited);
            return !unvisited.isEmpty() ? unvisited.iterator().next() : null;
        }
        return null;
    }

    public static void main(String[] args) {
        int maxX = 2;
        int maxY = 3;

        int n = 1;
        int r = 1;

        int[] x = {2};
        int[] y = {3};

        Graph graph = new Graph(maxX, maxY);

        // all fields inside circle
        for (int i = 1; i <= n; i++) {
            int centerX = x[i - 1];
            int centerY = y[i - 1];

            int xMin = 1;
            if (centerX - r >= 1) {
                xMin = centerX - r;
            }

            int xMax = maxX;
            if (centerX + r <= maxX) {
                xMax = centerX + r;
            }

            int yMin = 1;
            if (centerY - r >= 1) {
                yMin = centerY - r;
            }

            int yMax = maxY;
            if (centerY + r <= maxY) {
                yMax = centerY + r;
            }

            for (int xCircle = xMin; xCircle <= xMax; xCircle++) {
                for (int yCircle = yMin; yCircle <= yMax; yCircle++) {
                    if (Math.pow(xCircle - centerX, 2) + Math.pow(yCircle - centerY, 2) <= Math.pow(r, 2)) {
                        graph.removeEdge(new Field(xCircle, yCircle));
                    }
                }
            }
        }

        boolean ret = bfs(graph, new Field(maxX, maxY));
        System.out.println(ret ? "YES" : "NO");
    }
}
