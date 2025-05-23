import java.util.*;


class RemoveAdjacentDuplicates{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String result = removeAdjacentDuplicates(s);
        System.out.println(result);

        sc.close();
    }

    static String removeAdjacentDuplicates(String s){
        return helper(s);
    }

    static String helper(String s) {
        if (reduce(s).equals(s)) return s;
        return helper(reduce(s));
    }

    static String reduce(String s) {
        int i = 1;
        while (i < s.length()) {
            char ch1 = s.charAt(i-1);
            char ch2 = s.charAt(i);

            if (ch1 == ch2) {

                return (i - 2 < 0 ? "" : (s.substring(0, i - 2))) +
                        (i + 1 == s.length() ? "" : (s.substring(i + 1)));
            }
            i++;
        }
        return s;
    }
}
