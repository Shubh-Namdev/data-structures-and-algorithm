import java.util.*;

class GroupAnagram {
    static boolean isAnagram(String s1, String s2) {
        if ( s1.length() != s2.length()) return false;

        HashSet<Integer> set = new HashSet<>();
        for ( int i=0; i<s1.length(); i++) {
            for (int j=0; j<s2.length(); j++) {
                char s1Ch = s1.charAt(i);
                char s2Ch = s2.charAt(j);

                if (s1Ch == s2Ch && !set.contains(j)) {
                    set.add(j);
                    break;
                }
            }
            if (set.isEmpty()) return false;
        }
        return set.size() == s1.length();
    }

    public List<List<String>> groupAnagram(String []strs) {
        List<List<String>> result = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        for (int i=0; i<strs.length-1; i++) {
            if ( set.contains(strs[i])) continue;
            List<String> li = new ArrayList<>();
            for (int j=i+1; j<strs.length; j++) {
                if (isAnagram(strs[i].toLowerCase(),strs[j].toLowerCase())) {
                    if (!set.contains(strs[j])) {
                        set.add(strs[j]);
                        li.add(strs[j]);
                    }
                }
            }
            if (!set.contains(strs[i])) {
                li.add(strs[i]);
                result.add(li);
            }
        }
        List<String> oneLi = new ArrayList<>();
        oneLi.add(strs[strs.length-1]);
        result.add(oneLi);

        System.out.println(result);
        return result;
    }

    public static void main(String []args) {

        //System.out.println(isAnagram("baa","aba"));

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int check = 0;
        String []strs = new String[n];
        for(int i = 0 ; i < n ;i++) {
            strs[i] = scanner.next();
        }
        List<List<String>> result = new GroupAnagram().groupAnagram(strs);

        for (List<String> strings : result) {
            for (String string : strings) {
                System.out.printf("%s ", string);
            }
            System.out.println();
        }
    }
}