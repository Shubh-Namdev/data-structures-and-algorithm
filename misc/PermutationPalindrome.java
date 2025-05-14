import java.io.*;
import java.util.*;
import java.lang.Math;
public class  PermutationPalindrome {

    public static int isPermutationPalindrome(String s ) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }

        int ec=0,oc=0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                ec += 1;
            }else {
                oc += 1;
            }
        }

        if (s.length() % 2 == 0) {
            if (ec == (s.length()/2)) return 1;
            else return 0;
        }
        if (oc == 1) return 1;
        return 0;
    }

    public static void  main (String args []) {

        Scanner sc =  new  Scanner (System.in);
        int t = 1;
        t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            t--;
            String s = new String();
            s = sc.next();

            int flag = isPermutationPalindrome(s);
            if (flag == 1) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }

}
