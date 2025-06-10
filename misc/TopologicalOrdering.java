import java.util.*;

class TopologicalOrdering{
    private static Vector<Integer> topologicalOrdering(int n,Vector<Vector<Integer>> edges){
        Vector<Integer>[] adj = new Vector[n+1];
        for (int i=0; i<=n; i++) {
            adj[i] = new Vector<>();
        }
        for (Vector<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj[u].add(v);
        }

        Vector<Integer> inDegree = new Vector<>();
        for (int i=0; i<=n; i++) {
            inDegree.add(0);
        }

        for (Vector<Integer> nbrs : adj) {
            for (int nbr : nbrs) {
                inDegree.set(nbr, inDegree.get(nbr)+1);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (inDegree.get(i) == 0) {
                q.add(i);
            }
        }

        Vector<Integer> res = new Vector<>();
        while (!q.isEmpty()) {
            int node = q.remove();
            res.add(node);

            for (int nbr : adj[node]) {
                inDegree.set(nbr, inDegree.get(nbr)-1);
                if (inDegree.get(nbr) == 0) {
                    q.add(nbr);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Vector<Vector<Integer> > edges = new Vector<Vector<Integer> >();
        for(int i=0;i<e;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            Vector<Integer> edge = new Vector<Integer>();
            edge.add(u);
            edge.add(v);
            edges.add(edge);
        }
        Vector<Integer> answer = topologicalOrdering(n,edges);
        for(int elem : answer)
            System.out.print(elem+" ");
    }
}
