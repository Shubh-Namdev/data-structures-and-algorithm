import java.util.*;

class MyComp implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
            int i=0;
            while (i < s1.length()) {
                if (s1.charAt(i) < s2.charAt(i)) {
                    return -1;
                }else if (s1.charAt(i) > s2.charAt(i)) {
                    return 1;
                }
                i++;
            }
            return 0;
        }else if (s1.length() < s2.length()) {
            return -1;
        }else {
            return 1;
        }
    }
}

class NumSort {
    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String []arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        String []sortedArray = numSort(n, arr);

        for (String num : sortedArray) {
            System.out.print(num + " ");
        }

    }

    static String[] numSort(int n, String[] arr) {
        Arrays.sort(arr,new MyComp());
        return arr;
    }

    static String[] numSortBrute(int n, String[] arr) {
        int []a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(a);

        for (int i=0; i<n; i++) {
            arr[i] = String.valueOf(a[i]);
        }

        return arr;
    }
}
