import java.io.*;
import java.util.*;


class IntersectionOfTwoArraysBasic{
    public static void main(String []args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        int m = sc.nextInt();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            b.add(sc.nextInt());
        }
        List<Integer> result = intersectionOfTwoArrays(n,a,m,b);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Integer x : result) {
            output.write(x+" ");
        }
        output.flush();
    }

    static List<Integer> intersectionOfTwoArrays(int n, List<Integer>a, int m, List<Integer>b){
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            if (map.containsKey(a.get(i))) {
                map.put(a.get(i), map.get(a.get(i))+1);
            }else {
                map.put(a.get(i), 1);
            }
        }

        int j = 0;
        while (j < m) {
            if (map.containsKey(b.get(j))) {
                if ( map.get(b.get(j)) > 1) {
                    map.put(b.get(j), map.get(b.get(j))-1);
                    list.add(b.get(j));
                }else {
                    list.add(b.get(j));
                    map.remove(b.get(j));
                }
            }
            j++;
        }
        Collections.sort(list);


        return list;
    }

    static int uniqueWords(int n,String s[]){
        HashSet<String> set = new HashSet<>();

        int i=0;
        while (i <s.length) {
            set.add(s[i]);
            i++;
        }
        return set.size();
    }
}