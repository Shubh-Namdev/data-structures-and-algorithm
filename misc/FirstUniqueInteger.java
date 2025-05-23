import java.util.*;
class FirstUniqueInteger{
    public static int firstUniqueInteger(Vector<Integer> vec){
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i=0; i<vec.size(); i++) {
            Integer key = vec.get(i);
            if (map.containsKey(key)) {
                map.remove(key);
            }else {
                map.put(key,i);
            }
        }
        if (map.size() == (int)Math.floor(((double)map.size())/2)) return -1;


        int minIndex = Integer.MAX_VALUE;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            minIndex = Math.min(entry.getValue(),minIndex);
        }

        return vec.get(minIndex);
    }

    public static int firstUniqueIntegerBrute(Vector<Integer> vec){
        // Loop for checking each element
        for (int i = 0; i < vec.size(); i++) {
            int j;
            // Checking if ith element is present in array
            for (j = 0; j < vec.size(); j++)
                if (i != j && vec.get(i) == vec.get(j))
                    break;
            // if ith element is not present in array
            // except at ith index then return element
            if (j == vec.size())
                return vec.get(i);
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Vector<Integer> vec=new Vector<Integer>();
        for(int i=0;i<n;i++)
            vec.add(sc.nextInt());
        System.out.println(firstUniqueInteger(vec));
    }
}
