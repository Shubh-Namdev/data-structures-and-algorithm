import java.util.*;


class ReverseWordsInAString{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverseWordsInAString(s));
        sc.close();
    }

    static String reverseWordsInAString(String s){
        if (s.length() == 0) return s;
        Stack<String> st = new Stack<>();

        int i=0;
        while (i<s.length()) {
            StringBuilder sb = new StringBuilder();
            if (s.charAt(i) != 32) {
                while(s.charAt(i) != 32 && i<s.length()) {
                    sb.append(s.charAt(i));
                    i++;
                }
            }
            st.push(sb.toString());
            i++;
        }

        StringBuilder sb2 = new StringBuilder();
        while (!st.isEmpty()) {
            sb2.append(st.pop()).append(" ");
        }
        sb2.deleteCharAt(sb2.length()-1);
        return sb2.toString();
    }

    static String reverseWordsInAString1(String s){
        if (s.isEmpty()) return s;

        StringBuilder sb = new StringBuilder();
        String []words = s.split(" ");

        for (int i=words.length-1; i>=0; i--) {
            StringBuilder word = new StringBuilder();
            word.append(words[i]);
            for (int j=0; j<word.length(); j++) {
                if (word.charAt(j) == 32) {
                    word.deleteCharAt(j);
                }
            }
            if (!word.toString().isEmpty()) {
                sb.append(word).append(" ");
            }
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
