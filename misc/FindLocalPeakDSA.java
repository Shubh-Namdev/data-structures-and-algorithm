import java.util.*;

public class FindLocalPeakDSA {
    public static List<Integer> findLocalPeak(int N, int[] arr) {

        List<Integer> list = new ArrayList<>();

        int i = 0;
        while(i < N) {
            if (i == 0) {
                if (arr[i] > arr[i+1]) {
                    list.add(arr[i]);
                }
            }else if (i == N-1) {
                if (arr[i] > arr[i-1]) {
                    list.add(arr[i]);
                }
            }else {
                if (arr[i] > arr[i+1] && arr[i] > arr[i-1]) {
                    list.add(arr[i]);
                }
            }
            i++;
        }

        return list;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        List<Integer> ans = findLocalPeak(N, arr);
        for (int x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
