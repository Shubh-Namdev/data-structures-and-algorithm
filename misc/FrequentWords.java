import java.util.*;

class MapComparator implements Comparator<Map.Entry<String,Integer>> {
    @Override
    public int compare(Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2) {
        if (e1.getValue() != e2.getValue()) return e2.getValue()-e1.getValue();

        String s1 = e1.getKey();
        String s2 = e2.getKey();

        int n = Math.min(s1.length(), s2.length());
        int i=0;
        while (i < n) {
            char s1Ch = s1.charAt(i);
            char s2Ch = s2.charAt(i);
            if (s1Ch > s2Ch) return 1;
            else if (s2Ch > s1Ch) return -1;

            i++;
        }
        return s1.length()-s2.length();
    }
}
class FrequentWords{
    public static Vector<String> frequentWords(Vector<String> vec,int k){
        HashMap<String,Integer> map = new HashMap<>();

        for (int i=0; i<vec.size(); i++) {
            String key = vec.get(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            }else {
                map.put(key,1);
            }
        }
        List<Map.Entry<String,Integer>> li = new ArrayList<>(map.entrySet());
        li.sort(new MapComparator());

        Vector<String> res = new Vector<>();
        for (Map.Entry<String,Integer> entry : li) {
            res.add(entry.getKey());
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Vector<String> vec=new Vector<String>();
        for(int i=0;i<n;i++)
            vec.add(sc.next());
        int k=sc.nextInt();
        Vector<String> ans = frequentWords(vec, k);
        for(int i=0;i<k;i++)
            System.out.println(ans.get(i));
    }
}
