import java.util.*;


class BookReading{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int result = bookReading(n,h,a);
        System.out.println(result);
    }

    static int bookReading(int n,int h,int a[]){
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            if (a[i] > max) max = a[i];
        }

        int ans = 0;
        int s=1,e=max;
        while (s <= e) {
            int mid = s + ((e-s)/2);
            if (canAchieveTask(a,h,mid)) {
                ans = mid;
                e = mid-1;
            }else {
                s = mid+1;
            }
        }
        return ans;
    }

    static boolean canAchieveTask(int a[],int h,int mid) {
        int timeTaken = 0;
        for (int i=0; i<a.length; i++) {
            timeTaken += (int)Math.ceil((double)a[i]/mid);
        }

        return timeTaken <= h;
    }

    static int bookReadingMAXNAnd1(int n,int h,int a[]){
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            if (a[i] > max) max = a[i];
        }

        for (int i=1; i<=max; i++) {
            int timeUtil = 0;
            for (int j=0; j<n; j++) {
                timeUtil += (int)Math.ceil((double)a[j]/i);
            }
            if (timeUtil <= h) {
                return i;
            }
        }
        return 0;
    }
}
