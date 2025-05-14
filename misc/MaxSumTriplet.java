import java.util.*;

class MaxSumTriplet {
    public static void main(String args[]) {
        System.out.println(maxSumTriplet(5,new long[]{6,2,9,4,1}));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            long arr[] = new long[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextLong();

            long result = maxSumTriplet(n, arr);

            System.out.println(result);

        }

    }

    static long maxSumTriplet(int n, long arr[]) {
        long a[] = new long[n+1];
        a[n] = 0;

        for (int i=n-1; i>=0; --i) {
            a[i] = Math.max(a[i+1],arr[i]);
        }
        for (long val : a) {
            System.out.println(val);
        }
        return 0;
    }


    static long maxSumTripletOpti(int n, long arr[]) {
        //variables
        long maxSum = 0;
        //consider this loop for mid one in triplet
        for (int i=1; i<n-1; i++) {
            long first = 0;
            //check for greater element in left part but lesser than mid
            for (int j=0; j<i; j++) {
                if (arr[j] > first && arr[j] < arr[i]) {
                    first = arr[j];
                }
            }

            long last = 0;
            //check for greater element in right part
            for (int k=i+1; k<n; k++) {
                if (first == 0) break;
                if (arr[k] > last && arr[k] > arr[i]) {
                    last = arr[k];
                }
            }
            //check if triplet sum is greater than maxSum
            if (first + arr[i] + last > maxSum && last != 0) {
                maxSum = first + arr[i] + last;
            }
        }
        //return the result
        return maxSum;
    }


    static long maxSumTripletBrute(int n, long arr[]) {
        //variables
        long maxSum = 0;

        //iterate to fetch 3 values to find sum
        for ( int i=0; i<n-2; i++) {
            for ( int j=i+1; j<n-1; j++) {
                for ( int k=j+1; k<n; k++) {
                    if (isValid(arr[i],arr[j],arr[k])) {
                        if (arr[i] + arr[j] + arr[k] > maxSum) {
                            maxSum = arr[i]+arr[j]+arr[k];
                        }
                    }
                }
            }
        }
        return maxSum;
    }

    static boolean isValid(long a, long b, long c) {
        return (a<b && b<c);
    }
}
