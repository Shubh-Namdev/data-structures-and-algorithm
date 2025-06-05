import java.util.*;

public class PalindromePartitioning {
    ArrayList<ArrayList<String> > palindromePartitioning(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();

        partition(res, s, 0, path);

        return res;
    }

    void partition(ArrayList<ArrayList<String>> res, String s, int ind, ArrayList<String> curr) {
        if(ind == s.length()) {
            res.add(new ArrayList<String>(curr));
            return;
        }

        // Store the current substring
        String temp = "";

        for(int i = ind; i < s.length(); i++) {
            temp += s.charAt(i);

            // check if string temp is palindrome or not
            if(isPalindrome(temp)){

                // adds the string to current list
                curr.add(temp);

                // Recursive call for the remaining string
                partition(res, s, i+1, curr);

                // Remove the string from the current list - (backtracking)
                curr.remove(curr.size()-1);
            }
        }
    }

    boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        ArrayList<ArrayList<String> > result = new PalindromePartitioning().palindromePartitioning(s);
        for(int i = 0 ; i < result.size() ; i++) {
            for(int j = 0 ; j < result.get(i).size() ; j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
