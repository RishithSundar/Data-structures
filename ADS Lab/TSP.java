import java.util.*;
public class TSP {
    static int tsp(int[][] graph, boolean[] visited, int curr, int count, int cost, int start) {
        if (count == graph.length && graph[curr][start] > 0) {
            return cost + graph[curr][start];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] && graph[curr][i] > 0) {
                visited[i] = true;
                ans = Math.min(ans, tsp(graph, visited, i, count + 1, cost + graph[curr][i], start));
                visited[i] = false;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] graph = {{0, 10, 15, 20},
                         {10, 0, 35, 25},
                         {15, 35, 0, 30},
                         {20, 25, 30, 0}};
        boolean[] visited = new boolean[graph.length];
        visited[0] = true;
        int result = tsp(graph, visited, 0, 1, 0, 0);
        System.out.println("Min cost: " + result);
    }
}
