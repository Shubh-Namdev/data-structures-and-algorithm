import java.io.*;
import java.util.*;

public class ValidAnagram {
    public boolean validAnagram(String s, String t) {
        if ( s.length() != t.length()) return false;

        HashSet<Integer> index = new HashSet<>();
        for (int i=0; i<s.length(); i++) {
            boolean hasMatch = false;
            for (int j=0; j<t.length(); j++) {
                if (s.charAt(i) == t.charAt(j) && !index.contains(j)) {
                    index.add(j);
                    hasMatch = true;
                    break;
                }
            }
            if (!hasMatch) return false;

        }
        return index.size() == s.length();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        String t = in.readLine();

        boolean result = new ValidAnagram().validAnagram(s, t);
        System.out.print(String.valueOf(result));
    }
}