import java.io.*;
import java.util.*;

class ValidSudoku {
    public boolean validSudokuNW(char[][] board) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board.length; j++) {

                if (board[i][j] == '.') {

                    for (char ch='1'; ch <= '9'; ch++) {
                        if (isValidPosition(board, i, j, ch)) {
                            board[i][j] = ch;
                            if (validSudoku(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValidPosition(char [][]board, int r, int c, char ch) {
        for (int i=0; i<board.length; i++) {
            if (board[r][i] == ch) return false;
            if (board[i][c] == ch) return false;
            if (board[3*(r/3) + i/3][3*(c/3) + i%3] == ch) return false;
        }
        return true;
    }

    boolean validRow(char[][] mat, int row) {

        // Visited array to track occurrences
        int[] vis = new int[10];

        for (int i = 0; i < 9; i++) {

            // If the cell is not empty
            if (mat[row][i] != '.') {
                char val = mat[row][i];

                // If duplicate is found
                if (vis[val] != 0)
                    return false;

                // Mark the number as visited
                vis[val]++;
            }
        }
        return true;
    }

    // Checks for duplicates in the current column
    boolean colValid(char[][] mat, int col) {

        // Visited array to track occurrences
        int[] vis = new int[10];

        for (int i = 0; i < 9; i++) {

            // If the cell is not empty
            if (mat[i][col] != '.') {
                int val = mat[i][col];

                // If duplicate is found
                if (vis[val] != 0)
                    return false;

                // Mark the number as visited
                vis[val]++;
            }
        }
        return true;
    }

    // Checks for duplicates in the current 3x3 submatrix
    boolean subMatValid(char[][] mat, int startRow,
                               int startCol) {

        // Visited array to track occurrences
        int[] vis = new int[10];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                // Current element in the submatrix
                char curr = mat[row + startRow][col + startCol];

                // If the cell is not empty
                if (curr != '.') {

                    // If duplicate is found
                    if (vis[curr] != 0)
                        return false;

                    // Mark the number as visited
                    vis[curr]++;
                }
            }
        }
        return true;
    }

    // Validates the Sudoku board
    public boolean validSudoku(char[][] mat) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // Check if the row, column,
                // or submatrix is invalid
                if (!validRow(mat, i) || !colValid(mat, j)
                        || !subMatValid(mat, i - i % 3, j - j % 3))
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char board[][] = new char[9][9];
        for(int i = 0 ; i < 9 ; i++) {
            for(int j = 0 ; j < 9 ; j++) {
                board[i][j] = scanner.next().charAt(0);
            }
        }
        scanner.close();
        boolean result = new ValidSudoku().validSudoku(board);
        System.out.println(result);
    }
}
