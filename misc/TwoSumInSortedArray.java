import java.util.*;

class TwoSumInSortedArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        boolean res = twoSumInSortedArray(n, arr, k);

        String ans = (res) ? "Present" : "Not Present";

        System.out.println(ans);

    }

    //time complexity = n * n
    static boolean twoSumInSortedArray(int n, int arr[], int k) {
        //initialize required variables
        //run a outer loop which till n-2
        for (int i=0; i<n-1; i++) {
            //inner loop will start from i+1 till n-1
            for (int j=i+1; j<n; j++) {
                //check if target equal to pair
                if (arr[i] + arr[j] == k) return true;
            }
        }
        //in case not found
        return false;
    }

    //time complexity =
    static boolean twoSumInSortedArray1(int n, int arr[], int k) {
        //find the start for l and r
        int l = 0,r = n-1;
        //iterating and find condtion when to stop
        while ( l < r ) {
            //target found
            if (arr[l] + arr[r] == k) {
                return true;
            }
            // if addition is greater than target
            // will move from right to left
            else if (arr[l] + arr[r] > k) {
                r--;
            }
            //else move from left to right
            else {
                l++;
            }
        }
        //in case target not found
        return false;
    }
}
