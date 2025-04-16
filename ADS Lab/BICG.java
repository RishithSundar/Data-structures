import java.util.*;
public class BiconnectedComponents {
    private int time = 0;
    private List<List<Integer>> bccList = new ArrayList<>();
    private Stack<int[]> edgeStack = new Stack<>();
    public void findBCC(int u, boolean[] visited, int[] disc, int[] low, int parent, List<List<Integer>> adj) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                edgeStack.push(new int[]{u, v});
                findBCC(v, visited, disc, low, u, adj);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] >= disc[u]) {
                    List<Integer> bcc = new ArrayList<>();
                    while (true) {
                        int[] edge = edgeStack.pop();
                        bcc.add(edge[0]);
                        bcc.add(edge[1]);
                        if (edge[0] == u && edge[1] == v) break;
                    }
                    bccList.add(bcc);
                }
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
                edgeStack.push(new int[]{u, v});
            }
        }
    }
    public void biconnectedComponents(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];
        int[] disc = new int[n];
        int[] low = new int[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                findBCC(i, visited, disc, low, -1, adj);
            }
        }
        for (List<Integer> bcc : bccList) {
            System.out.println(bcc);
        }
    }
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        BiconnectedComponents bccFinder = new BiconnectedComponents();
        bccFinder.biconnectedComponents(n, adj);
    }
}
