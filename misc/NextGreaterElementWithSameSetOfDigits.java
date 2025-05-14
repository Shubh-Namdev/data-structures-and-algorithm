import java.util.*;

class NextGreaterElementWithSameSetOfDigits{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        System.out.print(nextGreaterElementWithSameSetOfDigits(n));
    }

    static int nextGreaterElementWithSameSetOfDigits(int n){
        int len = (int)Math.log10(n)+1;
        int []a = new int[len];
        for (int i=a.length-1; i>=0; i--) {
            a[i] = n%10;
            n /= 10;
        }

        int l=a.length-2,min=Integer.MAX_VALUE,minIndex=-1;
        while (l >= 0) {
            if (a[l] < a[l+1]) {
                int k = l+1;
                while (k < a.length) {
                    int diff = a[k] - a[l];
                    if (diff > 0 && diff < min) {
                        min = diff;
                        minIndex = k;
                    }
                    k++;
                }
                break;
            }
            l--;
        }
        if (l == -1) return -1;
        swap(a,l,minIndex);

        l = l+1; int r=a.length-1;
        while (l < r) {
            swap(a,l,r);
            l++;
            r--;
        }

        int res = 0;
        for (int num : a) {
            res = (res*10) + num;
        }
        return res;
    }

    static void swap(int []a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
