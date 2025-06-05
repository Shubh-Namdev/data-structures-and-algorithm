import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathTraverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        List<Boolean> res = new ArrayList<>();
        traverse(n, n, 0, 0, matrix, res);

        System.out.println(res.size());
    }

    static void traverse(int r, int c, int i, int j, int [][]matrix, List<Boolean> res ) {
        if (i >= r || j >= c) return ;
        if (matrix[i][j] != 1) return ;

        traverse(r, c, i, j + 1, matrix,res);
        traverse(r, c, i + 1, j, matrix,res);

        if (i == r-1 && j == c-1 && matrix[i][j] == 1) res.add(true);
    }
}
