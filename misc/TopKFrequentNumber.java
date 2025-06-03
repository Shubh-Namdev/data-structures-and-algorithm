import java.io.*;
import java.util.*;

class Comp implements Comparator<Map.Entry<Integer,Integer>> {
    @Override
    public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
        return o2.getValue() - o1.getValue();
    }
}

class TopKFrequent {

    // Implement your solution by completing the below function
    static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(Collections.reverseOrder(new Comp()));
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        for (int i=0; i<k; i++) {
            Map.Entry<Integer, Integer> e = pq.remove();
            res.add(e.getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; ++i)
            nums[i] = scanner.nextInt();

        int k = scanner.nextInt();
        scanner.close();

        List<Integer> result = topKFrequent(nums, k);
        for (Integer x: result) {
            System.out.print(x + " ");
        }
    }
}
