import java.util.*;

class CountSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        String res = countSort(n, s);

        System.out.println(res);

    }

    static String countSort(int n, String s) {
        char maxCh =0;
        for (int i=0; i<n; i++) {
            char temp = s.charAt(i);
            if (temp > maxCh) {
                maxCh = temp;
            }
        }

        int len = (maxCh - 97) + 1;
        int []countArr = new int[len];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            countArr[ch-97] = countArr[ch-97] + 1;
        }

        for (int i = 1; i < len; i++) {
            countArr[i] = countArr[i-1] + countArr[i];
        }
        for (int val : countArr) {
            System.out.print(val+" ");
        }
        System.out.println();

        char []outputArr = new char[n];
        for (int i = s.length()-1; i >= 0 ; i--) {
            char ch = s.charAt(i);
            outputArr[(countArr[ch-97] - 1)] = ch;
            countArr[ch-97]--;
        }

        for (char ch : outputArr) {
            System.out.print(ch+" ");
        }
        System.out.println();


        return Arrays.toString(outputArr);
    }
}
