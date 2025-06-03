import java.io.*;
import java.util.*;

class KthLargestElementInAnArray {

    // Implement your solution by completing the below function
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<k; i++) {
            pq.add(nums[i]);
        }

        for (int i=k; i<nums.length; i++) {
            int cur = nums[i];
            int top = pq.peek();

            if (cur > top) {
                pq.remove();
                pq.add(cur);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; ++i)
            nums[i] = scanner.nextInt();

        int k = scanner.nextInt();
        scanner.close();

        int result = new KthLargestElementInAnArray().findKthLargest(nums, k);
        System.out.println(result);
    }
}