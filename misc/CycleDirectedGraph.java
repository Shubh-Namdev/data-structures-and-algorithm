import java.util.*;

class CycleDirectedGraph{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] edges = new int[e][2];
        for(int i=0;i<e;i++){
            int a,b;
            a = sc.nextInt();
            b = sc.nextInt();
            edges[i][0]=a;
            edges[i][1]=b;
        }
        System.out.println(cycleDirectedGraph(n, edges));
        sc.close();
    }

    static int cycleDirectedGraph(int n, int[][] edges){
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i=0; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int []edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
        }

        boolean []visited = new boolean[n+1];
        boolean []tracker = new boolean[n+1];
        for (int i=1; i<=n; i++) {
            if (!visited[i]) {
                // checkCycle(i, visited, adj);
                // if (visited[i]) return 1;
                if (checkCycle(i, visited, adj, tracker)) return 1;
            }
        }
        return 0;
    }

    static boolean checkCycle(int node, boolean []visited, ArrayList<Integer>[] adj, boolean []tracker) {
        if (!visited[node]) {
            visited[node] = true;
            tracker[node] = true;

            for (int nbr : adj[node]) {
                if (!visited[nbr]) {
                    if (checkCycle(nbr, visited, adj, tracker)) return true;
                }else if (tracker[nbr]) return true;
            }
        }
        tracker[node] = false;
        return false;
    }

    static void checkCycle(int node, boolean []visited, ArrayList<Integer>[] adj) {
        //visited[node] = true;

        for (int nbr : adj[node]) {
            if (!visited[nbr]) {
                visited[nbr] = true;
                checkCycle(nbr, visited, adj);
            }
        }
    }

}
