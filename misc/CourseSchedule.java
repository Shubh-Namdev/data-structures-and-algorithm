import java.util.*;
class CourseSchedule {
    public static boolean courseScheduleOther(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses+1];
        for (int i=0; i<=numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int []prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];
            adj[u].add(v);
        }

        ArrayList<Integer> inDegree = new ArrayList<>();
        for (int i=0; i<=numCourses; i++) {
            inDegree.add(0);
        }
        for (List<Integer> nbrs : adj) {
            for (int nbr : nbrs) {
                inDegree.set(nbr, inDegree.get(nbr)+1);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=numCourses; i++) {
            if (inDegree.get(i) == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int course = q.remove();

                for (int nbr : adj[course]) {
                    inDegree.set(nbr, inDegree.get(nbr)-1);
                    if (inDegree.get(nbr) == 0) q.add(nbr);
                }
            }
        }
        return q.isEmpty();

    }

    public static boolean courseSchedule(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses+1];
        for (int i=0; i<=numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int []edge : prerequisites) {
            int u = edge[1];
            int v = edge[0];

            adj[u].add(v);
        }

        boolean []visited = new boolean[numCourses+1];
        boolean []tracker = new boolean[numCourses+1];
        for (int i=1; i<=numCourses; i++) {
            if (!visited[i]) {
                // checkCycle(i, visited, adj);
                // if (visited[i]) return 1;
                if (checkCycle(i, visited, adj, tracker)) return false;
            }
        }
        return true;
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


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] edgeList = new int[m][2];
        for(int i=0;i<m;i++)
        {
            edgeList[i][0] = sc.nextInt();
            edgeList[i][1] = sc.nextInt();
        }
        boolean ans=courseSchedule(n,edgeList);
        if(ans)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
