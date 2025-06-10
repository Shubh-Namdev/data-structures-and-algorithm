import java.util.*;

public class ConnectedComponentsInGraph {

    int connectedComponentsInGraph(int n,  ArrayList<ArrayList<Integer>> edges) {
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i=0; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean []visited = new boolean[n+1];
        int count = 0;
        for (int i=1; i<=n; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj);
                count++;
            }
        }
        return count;
    }

    void dfs(int node, boolean []visited, List<Integer>[] adj) {
        visited[node] = true;

        for (int nbr : adj[node]) {
            if (!visited[nbr]) {
                dfs(nbr, visited, adj);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();

        for(int i = 0;i < m; i++) {
            edges.add(new ArrayList<Integer>());
            edges.get(i).add(scanner.nextInt());
            edges.get(i).add(scanner.nextInt());
        }
        ConnectedComponentsInGraph answer = new ConnectedComponentsInGraph();
        int result = answer.connectedComponentsInGraph(n, edges);
        System.out.println(result);
        scanner.close();
    }
}
