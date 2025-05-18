import java.util.*;

class BackspaceStringCompare {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            String S = sc.next();
            String T = sc.next();

            boolean res = backspaceStringCompare(S, T);

            if (res)
                System.out.println(true);
            else
                System.out.println(false);

        }
    }

    static boolean backspaceStringCompare(String S, String T) {
        Stack<Character> st1 = new Stack<>();
        for (int i=0; i<S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '#') {
                if (!st1.isEmpty()) {
                    st1.pop();
                }
            }else {
                st1.push(ch);
            }
        }

        StringBuilder sb1 = new StringBuilder();
        while (!st1.isEmpty()) {
            sb1.append(st1.pop());
        }

        Stack<Character> st2 = new Stack<>();
        for (int i=0; i<T.length(); i++) {
            char ch = T.charAt(i);

            if (ch == '#') {
                if (!st2.isEmpty()) {
                    st2.pop();
                }
            }else {
                st2.push(ch);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        while (!st2.isEmpty()) {
            sb2.append(st2.pop());
        }

        return sb1.compareTo(sb2) == 0 ;
    }

}
