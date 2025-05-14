import java.util.*;


class LongestSubarrayHavingSumK{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.print(longestSubarray(arr,k));
    }

    // Function to find longest sub-array having sum k
    static int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;
        int prefSum = 0;

        for (int i = 0; i < arr.length; ++i) {
            prefSum += arr[i];

            // Check if the entire prefix sums to k
            if (prefSum == k)
                res = i + 1;

                // If prefixSum - k exists in the map then there exist such
                // subarray from (index of previous prefix + 1) to i.
            else if (mp.containsKey(prefSum - k))
                res = Math.max(res, i - mp.get(prefSum - k));

            // Store only first occurrence index of prefSum
            if (!mp.containsKey(prefSum))
                mp.put(prefSum, i);
        }

        return res;
    }


    static int longestSubarrayHavingSumK(int n, int k, int arr[]){
        int maxLen = 0;

        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j<n; j++) {
                sum += arr[j];

                if (sum == k) {
                    int len = (j-i) + 1;
                    maxLen = Math.max(len,maxLen);
                }else if (sum > k) {
                    break;
                }
            }
        }
        return maxLen;
    }
}
