import java.util.*;

public class RobotInAGrid {

    // Implement your Solution Here
    Vector<String> robotInAGrid(int [][]grid , int n , int m) {
        Vector<String> res = new Vector<>();

        boolean possible = path(n, m, 0 ,0, grid, res);

        if (!possible) {
            res = new Vector<>();
            res.add("Not Possible");
        }

        return res;
    }

    boolean path(int n, int m, int i, int j, int [][]grid, Vector<String> res) {
        if (i >= n || j >= m || grid[i][j] != 0) return false;

        res.add((i+1)+" "+(j+1));

        if (i == n-1 && j == m-1) return true;
        if (path(n, m, i, j+1, grid, res) || path(n, m, i+1, j, grid, res)) return true;

        res.remove(res.size()-1);
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int grid[][] = new int[n][m];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        RobotInAGrid answer = new RobotInAGrid();
        Vector<String> result = answer.robotInAGrid(grid , n , m);
        for(String elem : result)
        {
            System.out.println(elem);
        }
    }
}
