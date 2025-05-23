import java.util.*;

// Implement your solution here
class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> li = new ArrayList<>();
        HashMap<Character,Integer> pat = new HashMap<>();
        HashMap<Character,Integer> str = new HashMap<>();

        //filling the pattern map
        int n = s.length(), m = p.length();
        for(int i=0; i<m; i++) {
            char ch = p.charAt(i);
            if (pat.containsKey(ch))
                pat.put(ch, pat.get(ch)+1);
            else
                pat.put(ch,1);
        }

        //iterate over the string
        int i=0,j=0;
        while (j < n) {
            char ch = s.charAt(j);
            if (str.containsKey(ch))
                str.put(ch, str.get(ch)+1);
            else
                str.put(ch,1);

            if(j-i+1 == m) {
                if (str.equals(pat))
                    li.add(i);
                i++;
            }
            j++;
        }
        return li;
    }

    public List<Integer> findAnagramsN(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        StringBuilder windStr = new StringBuilder();
        for (int i=0; i<p.length(); i++) {
            windStr.append(s.charAt(i));
        }
        if (isAnagram(windStr.toString(),p)) {
            res.add(0);
        }

        for (int i=p.length(); i<s.length(); i++) {
            windStr = windStr.deleteCharAt(0);
            windStr.append(s.charAt(i));

            if (isAnagram(windStr.toString(),p)) {
                res.add(i-p.length()+1);
            }
        }

        return res;
    }

    static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int []arr = new int[26];
        for (int i=0; i<s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            arr[ch1 - 'a']++;
            arr[ch2 - 'a']--;
        }

        for (int val : arr) {
            if (val != 0) return false;
        }
        return true;
    }


    public List<Integer> findAnagramsBrute(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length()-p.length();

        for (int i=0; i<=n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=i; j<i+p.length(); j++) {
                sb.append(s.charAt(j));
            }

            char []sbArr = sb.toString().toCharArray();
            Arrays.sort(sbArr);

            char []pArr = p.toCharArray();
            Arrays.sort(pArr);

            String s1 = String.valueOf(sbArr);
            String s2 = String.valueOf(pArr);

            if (s1.equals(s2)) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = new String[2];
        input = scanner.nextLine().split(" ");
        String s = input[0];
        String p = input[1];
        scanner.close();

        List<Integer> result = new FindAllAnagramsInAString().findAnagrams(s,p);
        System.out.println(result.size());
        for (Integer i = 0; i < result.size(); ++i) {
            System.out.printf("%d ", result.get(i));
        }
    }
}
