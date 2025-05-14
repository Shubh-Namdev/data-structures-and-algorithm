import java.util.*;

class SortArrayDSA {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String []arr = new String[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.next();

        String []sortedArr = sortArray(n, arr);

        for (String word : sortedArr)
            System.out.print(word + " ");
    }

    // TODO: Implement this method
    static String[] sortArray(int n, String[] arr) {

        for (int i=0; i<n-1; i++) {
            for (int j = i+1; j < n; j++) {
                String smallString = compare(arr[i],arr[j]);

                if (smallString.equals(arr[j])) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    static String compare(String s1, String s2) {
        int i=0,j=0;
        boolean isEqual = false;

        while (i < s1.length() && j < s2.length()) {
            char ofFirstStr = s1.charAt(i);
            char ofSecondStr = s2.charAt(j);

            if (ofFirstStr < ofSecondStr) {
                return s1;
            } else if (ofSecondStr < ofFirstStr) {
                return s2;
            }else {
                i++;
                j++;
                isEqual = true;
            }
        }

        if (isEqual) {
            if (s1.length() < s2.length()) return s1;
            else return s2;
        }

        return "";
    }
}
