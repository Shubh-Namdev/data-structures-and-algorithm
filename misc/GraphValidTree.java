import java.util.*;
import java.lang.Integer;

class GraphValidTree{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[m][2];
        for(int i=0;i<m;i++){
            int a,b;
            a = sc.nextInt();
            b = sc.nextInt();
            edges[i][0] = a;
            edges[i][1] = b;
        }
        System.out.println(graphValidTree(n,edges));

        sc.close();
    }

    static int graphValidTree(int n, int[][] edges){
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int []edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean []visited = new boolean[n];
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                if (checkCycle(i, -1, visited, adj)) return 0;
            }
        }
        return 1;
    }

    static boolean checkCycle(int node, int parent, boolean []visited, List<Integer>[] adj) {
        visited[node] = true;

        for (int nbr : adj[node]) {
            if (!visited[nbr]) {
                if (checkCycle(nbr, node, visited, adj)) return true;
            }else if (nbr != parent) return true;
        }
        return false;
    }
}
