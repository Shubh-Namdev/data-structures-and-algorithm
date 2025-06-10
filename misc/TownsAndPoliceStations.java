import java.util.*;

public class TownsAndPoliceStations {
    static void MsBFS(ArrayList<Integer>[] adj, Queue<Integer> q, List<Integer> dist, boolean []visited) {
        while (!q.isEmpty()) {
            int k = q.remove();

            for (int nbr : adj[k]) {
                if (!visited[nbr]) {
                    q.add(nbr);
                    dist.set(nbr, dist.get(k)+1);
                    visited[nbr] = true;
                }
            }
        }
    }

    public static ArrayList<Integer> townsAndPoliceStations(int n,ArrayList<ArrayList<Integer> >  edges,ArrayList<Integer> sources){
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
        ArrayList<Integer> dist = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<sources.size(); i++) {
            q.add(sources.get(i));
            visited[sources.get(i)] = true;
        }

        MsBFS(adj, q, dist, visited);

        return dist;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        ArrayList<ArrayList<Integer> > edges = new ArrayList<ArrayList<Integer> >();
        for(int i=0;i<m;i++){
            edges.add(new ArrayList<Integer>());
        }
        for(int i=0;i<m;i++){
            int x,y;
            x= sc.nextInt();
            y = sc.nextInt();
            edges.get(i).add(x);
            edges.get(i).add(y);
        }
        int s = sc.nextInt();
        ArrayList<Integer> sources = new ArrayList<>();
        for(int i=0;i<s;i++){
            sources.add(sc.nextInt());
        }
        ArrayList<Integer> ans = TownsAndPoliceStations.townsAndPoliceStations(n,edges,sources);
        for(int distance:ans){
            System.out.println(distance+" ");
        }
        sc.close();
    }
}
