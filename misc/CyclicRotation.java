import java.util.*;

class CyclicRotation {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int rotatedArr[] = cyclicRotation(n, arr, k);

        for (int j : rotatedArr)
            System.out.print(j + " ");

    }

    // TODO: Implement this method
    static int[] cyclicRotation(int n, int[] arr, int k) {
        if ( n == k) return arr;
        if (k > n) {
            k = k % n;
        }

        int []rotatedArr = new int[n];
        int r= 0,j = n-k;
        while( j < n){
            rotatedArr[r] = arr[j];
            r++;
            j++;
        }

        int i = 0;
        while (i < n-k) {
            rotatedArr[r] = arr[i];
            i++;
            r++;
        }


        return rotatedArr;
    }
    static int[] cyclicRotation1(int n, int[] arr, int k) {
        int i=1;
        while(i <= k) {
            int temp = arr[0];
            arr[0] = arr[n-1];

            int j=n-2;
            while(j >= 1) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
            i++;
        }

        return arr;
    }
}
