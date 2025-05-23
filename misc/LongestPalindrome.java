import java.util.*;

class LongestPalindrome {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        int res = longestPalindrome(n, s);

        System.out.println(res);
    }

    static int longestPalindrome(int n, String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            }else {
                map.put(ch,1);
            }
        }

        int maxOdd = -1;
        int oddSum = 0;
        int evenSum = 0;
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val % 2 == 0) evenSum += val;
            else {
                maxOdd = Math.max(maxOdd,val);
                oddSum += (val-1);
            }
        }

        if (maxOdd == -1) return evenSum;
        oddSum += 1;
        return (oddSum + evenSum);
    }
}
