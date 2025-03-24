import java.util.*;
public class SSSPMatrix {
    static void dijkstra(int[][] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < n - 1; i++) {
            int u = -1;
            for (int v = 0; v < n; v++)
                if (!visited[v] && (u == -1 || dist[v] < dist[u]))
                    u = v;
            visited[u] = true;
            for (int v = 0; v < n; v++)
                if (!visited[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
        System.out.println("Distances: " + Arrays.toString(dist));
    }
    public static void main(String[] args) {
        int[][] graph = {{0, 10, 0, 30, 100},
                         {10, 0, 50, 0, 0},
                         {0, 50, 0, 20, 10},
                         {30, 0, 20, 0, 60},
                         {100, 0, 10, 60, 0}};
        dijkstra(graph, 0);
    }
}
