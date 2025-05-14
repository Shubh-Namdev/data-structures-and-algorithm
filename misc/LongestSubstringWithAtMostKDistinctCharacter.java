import java.util.*;

// Implement your solution here
class LongestSubstringWithAtMostKDistinctCharacter {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character,Integer> m = new HashMap<>();
        int l=0,j=0,ans=0;
        while ( j < s.length()) {
            char ch = s.charAt(j);
            if (m.containsKey(ch)) {
                m.put(ch, m.get(ch)+1);
            }else {
                m.put(ch, 1);
            }


            while (m.size() > k) {
                char p = s.charAt(l);
                if (m.get(p) > 1) {
                    m.put(p, m.get(p)-1);
                }else {
                    m.remove(p);
                }
                l++;
            }
            int len = j-l+1;
            ans = Math.max(len,ans);
            j++;
        }
        return ans;
    }

    public int lengthOfLongestSubstringKDistinctNAndN(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();

        int l=0,r=0,uc=0,len=0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (!map.containsKey(ch)) {
                uc++;
                if (uc <= k) {
                    map.put(ch,1);
                    r++;
                }else {
                    len = Math.max(len,(r-l));
                    if (map.get(s.charAt(l)) > 1) {
                        map.put(s.charAt(l), map.get(s.charAt(l))-1);
                        uc--;
                    }else {
                        map.remove(s.charAt(l));
                        uc -= 2;
                    }
                    l++;
                }
            }else {
                map.put(ch, map.get(ch)+1);
                r++;
            }
        }
        if (uc == k) return s.length();
        return len;
    }

    public int lengthOfLongestSubstringKDistinctNNAndN(String s, int k) {
        String res = "";
        for (int i=0; i<s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();

            int uc = 0;
            for (int j=i; j<s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    uc++;
                }
                sb.append(s.charAt(j));

                if (uc == k && sb.length() > res.length()) res = sb.toString();
            }
        }
        return res.isEmpty() ? s.length() : res.length();
    }

    public int lengthOfLongestSubstringKDistinctNNNAndN(String s, int k) {
        String res = "";
        int luc = 0;
        for (int i=0; i<s.length(); i++) {
            for (int j=i; j<s.length(); j++) {
                HashSet<Character> set = new HashSet<>();
                int uc = 0;
                StringBuilder sb = new StringBuilder();
                for (int l=i; l<=j; l++) {
                    sb.append(s.charAt(l));
                    if (!set.contains(s.charAt(l))) {
                        set.add(s.charAt(l));
                        uc++;
                    }
                }
                if (uc == k && sb.toString().length() > luc) {
                    luc = sb.toString().length();
                    res = sb.toString();
                }
            }
        }
        return res.isEmpty() ? s.length() : res.length();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        scanner.close();

        int result = new LongestSubstringWithAtMostKDistinctCharacter().lengthOfLongestSubstringKDistinct(s,k);
        System.out.println(result);
    }
}