import java.util.*;
class PossibleBipartition {
    private static String possibleBipartition(int n, Vector<Vector<Integer> > edges) {
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i=0; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (Vector<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj[u].add(v);
            adj[v].add(u);
        }

        int []color = new int[n+1];

        for (int i=1; i<=n; i++) {
            if (color[i] == 0) {
                if (colorTheVertex(i, 1, color, adj)) return "Possible";
            }
        }
        return "Not Possible";
    }

    static boolean colorTheVertex(int node, int cur_color, int []color, List<Integer>[] adj) {
        if (color[node] != 0) return color[node] == cur_color;

        color[node] = cur_color;
        for (int nbr : adj[node]) {
            if (!colorTheVertex(nbr, -cur_color, color, adj)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tests = 0; tests < t; tests++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Vector<Vector<Integer> > edges = new Vector<Vector<Integer> >();
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                Vector<Integer> edge = new Vector<Integer>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
            System.out.println(possibleBipartition(n, edges));
        }
        sc.close();
    }
}
