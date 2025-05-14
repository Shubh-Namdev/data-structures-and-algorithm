import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class  ContigiousSequence {

    public static Vector<Integer> printContigiousSequence(int []arr , int n) {
        long []prefix = new long[n];
        prefix[0] = Math.max(arr[0], 0);

        for (int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + arr[i] < 0 ? 0 : prefix[i-1] + arr[i];
        }

        long maxSum = Long.MIN_VALUE;
        int maxSumNegInd = 0;

        int s =-1,e=-1;
        for (int i=0; i<prefix.length; i++) {
            if (prefix[i] == 0) s=i;
            if (prefix[i] != 0 && prefix[i] > maxSum) {
                maxSum = prefix[i];
                e = i;
            }
            if (arr[i] > arr[maxSumNegInd]) {
                maxSumNegInd = i;
            }
        }
        Vector<Integer> maxSubSequenceArr;
        if (maxSum == Long.MIN_VALUE) {
            maxSubSequenceArr = new Vector<>();
            maxSubSequenceArr.add(arr[maxSumNegInd]);
            return  maxSubSequenceArr;
        }

        if (s == -1) {
            maxSubSequenceArr = new Vector<>();
            int j= 0;
            while (j < n) {
                maxSubSequenceArr.add(arr[j]);
                j++;
            }
            return maxSubSequenceArr;
        }
        maxSubSequenceArr = new Vector<>();
        int k = s+1;
        while (k <= e) {
            maxSubSequenceArr.add(arr[k]);
            k++;
        }
        return maxSubSequenceArr;
    }

    public static long contigiousSequence(int []arr , int n) {
        if (n == 0) return n;

        long maxSum = Long.MIN_VALUE;
        long []prefix = new long[n];
        prefix[0] = Math.max(arr[0], 0);

        for (int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + arr[i] < 0 ? 0 : prefix[i-1] + arr[i];

            if (prefix[i] > maxSum) maxSum = prefix[i];
        }
        if (arr[0] > maxSum) maxSum = prefix[0];

        return maxSum;
    }

    public static long contigiousSequenceNAndN(int []arr , int n) {
        if (n == 0) return n;

        long maxSum = Long.MIN_VALUE;
        long []prefix = new long[n];
        prefix[0] = Math.max(arr[0], 0);

        for (int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + arr[i] < 0 ? 0 : prefix[i-1] + arr[i];

            if (prefix[i] > maxSum) maxSum = prefix[i];
        }
        if (arr[0] > maxSum) maxSum = prefix[0];

        return maxSum;
    }

    //complexity -> O(n*n),O(n)
    public static  long contigiousSequenceNNAndN(int []arr , int n) {
        if (n == 0) return n;

        long maxSum = Long.MIN_VALUE;
        long []prefix = new long[n];
        prefix[0] = arr[0];

        for (int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        for (int l=0; l<n; l++) {
            for (int r=l; r<n; r++) {
                long tempSum = l>0 ? prefix[r] - prefix[l-1] : prefix[r];
                if (tempSum > maxSum) maxSum=tempSum;
            }
        }
        return maxSum;
    }

    //complexity -> O(n*n),O(n*n)
    public static  long contigiousSequenceNNAndNN(int []arr , int n) {
        if (n == 0) return n;

        long maxSum = Long.MIN_VALUE;
        for (int i=0; i<n; i++) {
            long []prefix = new long[n];
            prefix[i] = arr[i];
            for (int k=i+1; k<n; k++) {
                prefix[k] = prefix[k-1]+arr[k];
            }

            for (int j=i; j<n; j++) {
                if (prefix[j] > maxSum) {
                    maxSum = prefix[j];
                }
            }
        }
        return maxSum;
    }

    //complexity O(n*n*n),O(1)
    public static  long contigiousSequenceNNNAnd1(int []arr , int n) {
        long maxSum = Long.MIN_VALUE;

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                long tempSum = 0;
                int k = i;
                while (k <= j) {
                    tempSum += arr[k];
                    k++;
                }
                if (tempSum > maxSum) {
                    maxSum = tempSum;
                }
            }
        }
        return maxSum;
    }

    public static void  main (String []args) {

        Scanner sc =  new  Scanner (System.in);

        int n = sc.nextInt();
        int []arr = new int[n];
        for ( int i = 0 ; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(printContigiousSequence(arr, n));

    }
}
