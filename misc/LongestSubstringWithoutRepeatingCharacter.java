import java.util.*;

class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int longestSubstringLength = 0;

        int l=0,r=0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (set.contains(ch)) {
                while (l != r) {
                    set.remove(l);
                    l++;
                }
            }else {
                set.add(ch);
                int len = r-l+1;
                longestSubstringLength = Math.max(len, longestSubstringLength);
                r++;
            }
        }

        return longestSubstringLength;
    }

    public int lengthOfLongestSubstringNNAndN(String s) {
        int longestSubstringLength = 0;

        for (int i=0; i<s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j=i; j<s.length(); j++) {
                char ch = s.charAt(j);
                if (set.contains(ch)) {
                    break;
                }else {
                    set.add(ch);
                    int len = j-i+1;
                    longestSubstringLength = Math.max(len,longestSubstringLength);
                }
            }
        }
        return longestSubstringLength;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int result = new LongestSubstringWithoutRepeatingCharacter().lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
