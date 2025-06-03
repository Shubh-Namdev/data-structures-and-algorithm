import java.io.*;
import java.util.*;
import java.lang.*;

public class LetterCombinationsOfPhoneNumber {
    HashMap<String,String> map = new HashMap<>();

    public List<String> letterCombinationsOfPhoneNumber(String digits) {
        map.put("1","abc");
        map.put("2","def");
        return letterRecurse(digits, new ArrayList<>());
    }

    List<String> letterRecurse(String digits, List<String> combinations) {
        if (digits.isEmpty()) return combinations;

        List<String> combi = sets(digits.substring(digits.length()-1), combinations);
        return letterRecurse(digits.substring(0,digits.length()-1), combi);
    }

    List<String> sets(String letter, List<String> c) {
        List<String> res = new ArrayList<>();

        String s = map.get(letter);
        if (c.isEmpty()) {
            int i=0;
            while (i < s.length()) {
                res.add(String.valueOf(s.charAt(i)));
                i++;
            }
        }else {
            int i=0;
            while (i < s.length()) {
                for(int j=0; j<c.size(); j++) {
                    res.add(c.get(j)+s.charAt(i));
                }
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        List<String> combinations = new LetterCombinationsOfPhoneNumber().letterCombinationsOfPhoneNumber(line);
        for (String cmbn : combinations)
            System.out.print(cmbn + " ");
    }
}
