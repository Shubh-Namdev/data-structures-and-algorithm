import java.util.*;
import java.io.*;

class DetectCycle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while ((t--) > 0) {
            int nodes = sc.nextInt();
            int e = sc.nextInt();
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < e; i++) {
                ArrayList<Integer> b = new ArrayList<Integer>();
                b.add(sc.nextInt());
                b.add(sc.nextInt());
                edges.add(b);
            }
            String ans = DetectCycle.detectCycle(nodes, edges);
            System.out.println(ans);
        }
        sc.close();
    }

    // Implement your Solution Here
    public static String detectCycle(int nodes, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<Integer>[] adj = new ArrayList[nodes+1];
        for (int i=0; i<=nodes; i++) {
            adj[i] = new ArrayList<>();
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }

        ArrayList<Boolean> visited = new ArrayList<>(Collections.nCopies(nodes+1, false));

        for (int i=1; i<=nodes; i++) {
            if (!visited.get(i)) {
                if (checkCycle(i, -1, visited, adj)) return "Yes";
            }
        }
        return "No";
    }

    static boolean checkCycle(int node, int parent, List<Boolean> visited, List<Integer>[] adj) {
        visited.set(node, true);

        for (int nbr : adj[node]) {
            if (!visited.get(nbr)) {
                if (checkCycle(nbr, node, visited, adj)) return true;
            }else if (nbr != parent) return true;
        }
        return false;
    }

}
