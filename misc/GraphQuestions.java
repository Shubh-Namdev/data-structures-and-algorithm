import java.util.*;

public class GraphQuestions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        //int [][]graphMatrix = new int[vertices+1][vertices+1];
        //constructGraphUsingMatrix(sc.nextInt(), sc.nextInt(), graphMatrix);

        List<List<Integer>> graphList = new ArrayList<>();
        for (int i=0; i<=vertices; i++) {
            graphList.add(new ArrayList<>());
        }

        for (int i=1; i<=edges; i++) {
            constructGraphUsingList(sc.nextInt(), sc.nextInt(), graphList);
        }

        /*
        for (List<Integer> li : graphList) {
            System.out.println(li);
        }
         */

        //System.out.println(graphBFS(1, graphList, vertices));
        boolean []visited = new boolean[vertices+1];
        visited[0] = true;
        List<Integer> res = new ArrayList<>();
        graphDFS(1, graphList, res, visited);
        System.out.println(res);
    }

    static void constructGraphUsingList(int source, int destination, List<List<Integer>> graphList) {
        graphList.get(source).add(destination);
        graphList.get(destination).add(source);

        //in case of weighted graph, make a pair of weight and destination and add it
    }

    static void constructGraphUsingMatrix(int source, int destination, int[][] graphMatrix) {
        graphMatrix[source][destination] = 1;
        graphMatrix[destination][source] = 1;

        //in case of weighted graph. storing weight on co-ordinates instaed of 1
    }

    static List<Integer> graphBFS(int v, List<List<Integer>> al,int n) {
        List<Integer> res = new ArrayList<>();
        boolean []visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[1] = true;

        while(!q.isEmpty()) {
            int vertex = q.remove();
            res.add(vertex);

            for (Integer vNeighbour : al.get(vertex)) {
                if (!visited[vNeighbour]) {
                    visited[vNeighbour] = true;
                    q.add(vNeighbour);
                }
            }

        }
        return res;
    }

    static void graphDFS(int v, List<List<Integer>> al, List<Integer> res , boolean []visited) {

        visited[1] = true;
        res.add(v);

        for (int vNeighbour : al.get(v)) {
            if (!visited[vNeighbour]) {
                visited[vNeighbour] = true;
                graphDFS(vNeighbour, al, res, visited);
            }
        }
    }
}
