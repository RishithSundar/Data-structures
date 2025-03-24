import java.util.*;

public class SSSPListSimple {
    static void dijkstra(Map<Integer, List<int[]>> graph, int src, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0], weight = neighbor[1];
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new int[]{1, 10}, new int[]{2, 20}));
        graph.put(1, Arrays.asList(new int[]{2, 5}, new int[]{3, 1}));
        graph.put(2, Arrays.asList(new int[]{3, 2}));
        graph.put(3, new ArrayList<>());

        dijkstra(graph, 0, 4);
    }
}
