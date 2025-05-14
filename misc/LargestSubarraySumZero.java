import java.util.*;

class LargestSubarraySumZero {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        ArrayList<Integer> res = largestSubarraySumZero(n, arr);

        for (int j : res)
            System.out.print(j + " ");

    }

    static ArrayList<Integer> largestSubarraySumZero(int n, int arr[]) {
        int lsa = 0,s=-1,e=-1;
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0L,-1);

        long prefix = 0;
        for (int i=0; i<n; i++) {
            prefix += arr[i];

            if (map.containsKey(prefix)) {
                int len = (i - (map.get(prefix) + 1)) + 1;
                if (len > lsa) {
                    lsa = len;
                    s = map.get(prefix) + 1;
                    e = i;
                }
            }else {
                map.put(prefix, i);
            }
        }

        ArrayList<Integer> li = new ArrayList<>();
        while (s <= e) {
            li.add(arr[s]);
            s++;
        }

        return li;
    }
}
