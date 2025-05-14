import java.util.*;

class MostFrequent {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Object[] ans = mostFrequent(s);
        System.out.println(ans[0] + " " + ans[1]);
    }

    // TODO: Implement this method
    static Object[] mostFrequent(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        int i=0;
        while (i < s.length()) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
            i++;
        }

        char maxKey=0;
        int max1 = Integer.MIN_VALUE;
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if (entry.getValue() > max1) {
                max1 = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        map.remove(maxKey);

        char maxKey2=0;
        int max2 = Integer.MIN_VALUE;
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if (entry.getValue() > max2) {
                max2 = entry.getValue();
                maxKey2 = entry.getKey();
            }
        }

        if (max1 == max2) {
            return new Object[]{(char)Math.min(maxKey,maxKey2),max1};
        }

        return new Object[]{maxKey,max1};
    }
}