import java.io.*;
import java.util.*;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                boolean isExist = find(r, c, i, j, board, word, 0);
                if (isExist) return true;
            }
        }
        return false;
    }

    boolean find(int r, int c, int i, int j, char[][] m, String word, int strIdx) {
        if (strIdx == word.length()) return true;
        if (i < 0 || i >= r || j < c || j >= c || m[i][j] != word.charAt(strIdx)) return false;

        boolean left = find(r, c, i, j-1, m, word, strIdx+1);
        boolean right = find(r, c, i, j+1, m, word, strIdx+1);
        boolean up = find(r, c, i-1, j, m, word, strIdx+1);
        boolean down = find(r, c, i+1, j, m, word, strIdx+1);

        return left || right || up || down;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        char board[][] = new char [row][col];
        for(int i = 0 ; i < row ; i++) {
            for(int j = 0 ; j < col;  j++) {
                board[i][j] = scanner.next().charAt(0);
            }
        }
        String word = scanner.next();
        scanner.close();
        boolean result = new WordSearch().exist(board , word);
        System.out.println(result);
    }
}
