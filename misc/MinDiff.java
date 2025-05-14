import java.util.*;

class MinDiff {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int res = minDiff(n, a);

        System.out.println(res);

    }

    static int minDiff(int n, int a[]) {
        Arrays.sort(a);

        int minDiff = Integer.MAX_VALUE;
        int l=0, r=1;
        while (r < n) {
            if (a[l] == a[r]) {
                l++;
                r++;
            }else {
                return Math.min(minDiff,(a[r]-a[l]));
            }
        }
        return 0;
    }
}