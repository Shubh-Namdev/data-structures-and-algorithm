import java.util.Scanner;
import java.util.Stack;

public class SortUsing2Stack {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }

        System.out.println(sort(st));

    }

    static Stack<Integer> sort(Stack<Integer> st) {
        Stack<Integer> res = new Stack<>();

        while (!st.isEmpty()) {
            int prevStVal = st.pop();
            if (!res.isEmpty()) {
                 if (prevStVal < res.peek()) {
                     while (!res.isEmpty() && res.peek() > prevStVal) {
                         st.push(res.pop());
                     }
                     res.push(prevStVal);
                 }else {
                     res.push(prevStVal);
                 }
            }else {
                res.push(prevStVal);
            }
        }
        return res;
    }
}
