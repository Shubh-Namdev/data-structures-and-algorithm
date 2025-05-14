import java.io.*;
import java.util.*;

public class ValidParenthesis {
    // Implement your solution here
    public String isValid(String s) {
        Stack<Character> st = new Stack<>();

        int i=0;
        while(i < s.length()) {
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (s.charAt(i) == ')' && st.peek() =='(') {
                    st.pop();
                }else if (s.charAt(i) == '}' && st.peek() =='{') {
                    st.pop();
                }else if (s.charAt(i) == ']' && st.peek() =='[') {
                    st.pop();
                }else {
                    return "false";
                }
                i++;
            }else {
                st.push(s.charAt(i));
                i++;
            }
        }
        if ( st.isEmpty()) return "true";
        return "false";
    }

    public String isValidAlt(String s) {
        if (s.length() == 0) return "true";
        if (s.length() == 1) return "false";

        char []temp = new char[s.length()];
        int i=0,j=0;
        while(i < s.length()) {
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if ( j - 1 == -1) return "false";
                if (s.charAt(i) == ')' && temp[j-1] == '('){
                    j--;
                }else if (s.charAt(i) == '}' && temp[j-1] == '{'){
                    j--;
                }else if (s.charAt(i) == ']' && temp[j-1] == '[') {
                    j--;
                }else {
                    return "false";
                }
                i++;
            }else {
                temp[j] = s.charAt(i);
                i++;
                j++;
            }
        }
        if (j > 0) {
            return "false";
        }
        return "true";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String parenthesis = in.readLine();
        String result = new ValidParenthesis().isValid(parenthesis);
        System.out.print(String.valueOf(result));
    }
}