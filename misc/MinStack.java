import java.util.*;

class MinStack {
    static Stack<Integer> stack = new Stack<Integer>();
    static Stack<Integer> min = new Stack<Integer>();

    static void push(Integer e) {
        if (!min.isEmpty()) {
            if (e <= min.peek()) {
                min.push(e);
            }else {
                min.push(min.peek());
            }
        }else {
            min.push(e);
        }
        stack.push(e);
    }

    static void pop() {
        if (!stack.isEmpty()) stack.pop();
        if (!min.isEmpty()) min.pop();
    }

    static Integer findMin() {
        if (!min.isEmpty()) return min.peek();
        else return -1;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            Integer a = sc.nextInt();
            if (a == 1) {
                Integer e = sc.nextInt();
                push(e);
            }
            if (a == 2) {
                pop();
            }
            if (a == 3) {
                System.out.println(findMin());
            }
        }
    }
}
