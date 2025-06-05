import java.util.*;

public class NQueens {
    boolean ansExist = false;
    String ans;
    String nQueens(int n) {
        ans = new String();
        int []queens = new int[n];

        getQueenPosition(0, queens, n);

        if (!ansExist) return "No Solution Exists";
        return ans;

    }

    void getQueenPosition(int current_row, int []qPos, int n) {
        if (current_row == n) {
            appendAnswer(qPos, n);
            ansExist = true;
        }

        for (int i=0; i<n; i++) {
            if (isValidPos(current_row, i, qPos)) {
                qPos[current_row] = i;
                getQueenPosition(current_row+1, qPos, n);
            }
        }
    }

    boolean isValidPos(int current_row, int current_col, int []qPos) {
        boolean isValid = true;
        for(int j=0; j<current_row; j++) {
            if (qPos[j] == current_col) {
                isValid = false;
                break;
            }

            if (Math.abs(qPos[j] - current_col) == Math.abs(current_row - j)) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    void appendAnswer(int []qPos, int n) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (qPos[j] == i) ans += "1";
                else ans += "0";
            }
            ans += "\n";
        }
        ans += "\n";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        scanner.close();
        NQueens result = new NQueens();
        String board = result.nQueens(n);
        System.out.println(board);
    }
}
