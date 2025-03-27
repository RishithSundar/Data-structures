import java.util.*;
public class BFTList {
    static void bfs(Map<Integer, List<Integer>> graph, int node) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(node);
        visited.add(node);
        while (!q.isEmpty()) {
            int currentNode = q.poll();
            System.out.print(currentNode + " ");
            for (int neighbor : graph.get(currentNode)) {
                if (!visited.contains(neighbor)) {
                    q.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 2, 3));
        graph.put(2, Arrays.asList(0, 1, 3));
        graph.put(3, Arrays.asList(1, 2));
        System.out.print("BFT: ");
        bfs(graph, 0);
    }
}
