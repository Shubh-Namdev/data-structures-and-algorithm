import java.util.*;

class CheckMagicSquare {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int grid[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        }

        String result = checkMagicSquare(n, grid);

        System.out.println(result);

    }

    // TODO: Implement this method
    static String checkMagicSquare(int n, int[][] grid) {
        int i = 0;
        boolean hasCalculated = false;
        do {
            int rowSum = 0, colSum = 0, diag1Sum = 0, diag2Sum = 0;
            for (int j=0; j<n; j++) {
                if (!hasCalculated) {
                    diag1Sum += grid[j][j];
                    diag2Sum += grid[n-1-j][j];
                }

                rowSum += grid[i][j];
                colSum += grid[j][i];
            }

            if (rowSum == colSum && rowSum == diag1Sum && rowSum == diag2Sum) {
                hasCalculated = true;
                i++;
            }else {
                return "No";
            }
        }while(i < n);

        return "Yes";
    }
}