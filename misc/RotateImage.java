import java.io.*;
import java.util.*;

public class RotateImage {
    public void swap(int [][]matrix,int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }

    public void transpose(int [][]matrix) {
        for (int row=0; row<matrix.length; row++) {
            for ( int col=row; col<matrix.length; col++) {
                swap(matrix,row,col,col,row);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        
    }

    public void reverse(int [][]matrix) {

    }

    public void rotateImage(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    public void rotateImage1(int[][] matrix) {
        int n = matrix.length;
        int [][]res = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                res[i][j] = matrix[n-1-j][i];
            }
        }

        System.arraycopy(res,0,matrix,0,n);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; ++i) {
            for (int j = 0; j < matrixSize; ++j) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        new RotateImage().rotateImage(matrix);
        for (int i = 0; i < matrixSize; ++i) {
            for (int j = 0; j < matrixSize; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}