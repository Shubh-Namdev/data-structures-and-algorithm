import java.io.*;
import java.util.*;

class NumberOfIslands {
    public int numIslands(ArrayList<String> grid) {
        int n = grid.size();
        int m = grid.getFirst().length();
        char [][]adj = new char[n][m];
        for (int i=0; i<n; i++) {
            adj[i] = grid.get(i).toCharArray();
        }

        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (adj[i][j] != '1') {
                    dfs(i, j, n, m, adj);
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(int i, int j, int r, int c, char [][]adj) {
        if (i < 0 || i >= r || j < 0 || j >= c || adj[i][j] != 1) return;

        adj[i][j] = '2';
        dfs(i, j-1, r, c, adj);
        dfs(i, j+1, r, c, adj);
        dfs(i-1, j, r, c, adj);
        dfs(i+1, j, r, c, adj);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine(); // Move to the next line
        ArrayList<String> grid = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            grid.add(scanner.nextLine());
        }
        int result = new NumberOfIslands().numIslands(grid);
        System.out.println(result);
    }
}
