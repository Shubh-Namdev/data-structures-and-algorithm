public class CanPalindromeFormed {
    public static void main(String[] args) {
        System.out.println(canFormPalindrome("abecbea"));
    }

    static boolean canFormPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(0,i) + s.substring(i+1);
            if (isPalindrome(temp)) return true;
        }
        return false;
    }

    static boolean isPalindrome(String s) {
        int l=0,r=s.length()-1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
