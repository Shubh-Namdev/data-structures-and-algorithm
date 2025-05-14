import java.util.*;

class RemoveDuplicatesFromSortedArrayII {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int res = removeDuplicatesFromSortedArrayII(n, arr);

        System.out.println(res);

        for (int i = 0; i < res; i++)
            System.out.print(arr[i] + " ");

    }

    static int removeDuplicatesFromSortedArrayII(int n, int[] arr) {
        int i=0,j=i+2;
        int newLength = n;
        while (j < newLength) {
            if (arr[i] == arr[j]) {
                int k = j,count = 0;
                while (arr[j] == arr[k] && k < newLength) {
                    count++;
                    k++;
                }
                if (j+count < newLength) {
                    i = j;
                    while (k < newLength) {
                        arr[j] = arr[k];
                        j++;
                        k++;
                    }
                }
                newLength = newLength - count;
            }else {
                i++;
            }
            j = i+2;
        }
        return newLength;
    }

}
