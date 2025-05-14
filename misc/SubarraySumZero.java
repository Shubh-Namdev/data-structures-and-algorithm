import java.util.*;

class SubarraySumZero{
    public static Vector<Integer> printSubarraySumZero(Vector<Integer> arr){
        HashMap<Long,Integer> map = new HashMap<>();

        long prefix = 0;
        Vector<Integer> subArraySumZero = new Vector<>();

        for (int i=0; i<arr.size(); i++) {
            prefix += arr.get(i);

            if (prefix == 0) {
                subArraySumZero = new Vector<>();
                int j=0;
                while(j <= i) {
                    subArraySumZero.add(arr.get(j));
                    j++;
                }
                return subArraySumZero;
            }
            if (map.containsKey(prefix)) {
                subArraySumZero = new Vector<>();
                int j = map.get(prefix) + 1;
                while (j <= i) {
                    subArraySumZero.add(arr.get(j));
                    j++;
                }
                return subArraySumZero;
            }
            map.put(prefix,i);
        }
        return subArraySumZero;
    }

    public static String subarraySumZero(Vector<Integer> arr){
        HashSet<Long> set = new HashSet<>();

        long sum = 0;
        set.add(sum);

        for (Integer integer : arr) {
            sum += integer;

            if (set.contains(sum)) return "Yes";
            set.add(sum);
        }
        return "No";
    }

    public static String subarraySumZeroNNAndN(Vector<Integer> arr){
        int []v = new int[arr.size()];
        v[v.length-1] = arr.getLast();

        for (int j=v.length-2; j>=0; j--) {
            v[j] = v[j+1] + arr.get(j);
        }

        for (int l=0; l<arr.size(); l++) {
            if (arr.get(l) == 0) return "Yes";

            for (int r=0; r<arr.size(); r++) {
                int tempSum = r < arr.size()-1 ? v[l] - v[r+1] : v[l];
                if (tempSum == 0) return "Yes";
            }
        }
        return "No";
    }

    public static String subarraySumZeroNNAndNN(Vector<Integer> arr){
        for (int i=0; i<arr.size(); i++) {
            if (arr.get(i) == 0) return "Yes";

            int []v = new int[arr.size()];
            v[i] = arr.get(i);

            for (int j=i+1; j<arr.size(); j++) {
                v[j] = v[j-1] + arr.get(j);

                if (v[j] == 0) return "Yes";
            }
        }
        return "No";
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int j=0;j<t;j++)
        {
            int n=sc.nextInt();
            Vector<Integer> arr=new Vector<Integer>();
            for(int i=0;i<n;i++)
            {
                arr.add(sc.nextInt());
            }
            System.out.println(printSubarraySumZero(arr));
        }

    }
}
