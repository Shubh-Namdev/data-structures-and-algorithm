import java.sql.Array;
import java.util.*;

public class IntegerPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        List<List<Integer>> res = intSets(arr);
        for (List<Integer> li : res) {
            System.out.print("[");
            for (int val : li) {
                System.out.print(","+val);
            }
            System.out.println("]");
        }
    }

    static List<List<Integer>> intSets(int []arr) {
        List<List<Integer>> res = new ArrayList<>();

        /*
        List<Integer> cur = new ArrayList<>();
        boolean []freq = new boolean[arr.length];
        getSetsUsingMap(arr, cur, res, freq);
         */
        getSets(0, arr, res);

        return res;
    }

    static void getSets(int idx, int []arr, List<List<Integer>> res) {
        if (idx == arr.length) {
            List<Integer> ans = new ArrayList<>();
            for (int val : arr) {
                ans.add(val);
            }
            res.add(ans);
            return;
        }

        for (int i=idx; i<arr.length; i++) {
            swap(arr, idx, i);
            getSets(idx+1, arr, res);
            swap(arr, idx, i);
        }
    }

    static void swap(int []arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void getSetsUsingMap(int []arr, List<Integer> cur, List<List<Integer>> res, boolean []freq) {
        if (cur.size() == arr.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!freq[i]) {
                cur.add(arr[i]);
                freq[i] = true;
                getSetsUsingMap(arr, cur, res, freq);
                cur.remove(cur.size()-1);
                freq[i] = false;
            }
        }
    }


}
