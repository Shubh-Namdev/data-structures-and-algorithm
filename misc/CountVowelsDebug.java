import java.util.*;

class CountVowelsDebug {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<Character, Integer> result = countVowels(str);
        for (Map.Entry<Character, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static Map<Character, Integer> countVowels(String s){
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if ( c >= 65 && c <= 90) {
                c = (char)(c + 32);
            }
            if (isVowel(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return map;
    }

    public static boolean isVowel(char c) {
        if ("aeiou".indexOf(c) == -1) return false;
        return true;
    }
}
