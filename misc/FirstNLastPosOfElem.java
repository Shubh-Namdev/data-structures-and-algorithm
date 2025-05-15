import java.util.Scanner;

public class FirstNLastPosOfElem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int []a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int []res = firstNLasPos(a,target);
        for (int elem : res) {
            System.out.print(elem+" ");
        }
        System.out.println();
    }

    static int[] firstNLasPos(int []a,int k) {
        int s=0,e=a.length-1;
        while (s <= e) {
            int mid = s + ((e-s)/2);

            if (a[mid] == k) {
                int l=mid-1,r=mid+1;
                while (l >=0 && a[l] == k) {
                    l--;
                }
                while (r < a.length && a[r] == k) {
                    r++;
                }

                return new int[]{l+1,r-1};
            }else if (a[mid] > k) {
                e = mid-1;
            }else {
                s = mid+1;
            }
        }
        return new int[]{-1,-1};
    }

    static int[] firstNLasPosNAnd1(int []a,int k) {
        int []res = new int[2];

        int s=-1,e=-1,r=0;
        while (r < a.length) {
            if (a[r] == k) {
                s = r;
                while (a[r] == k && r < a.length) {
                    r++;
                }
                e = r-1;
                break;
            }
            r++;
        }
        res[0] = s;
        res[1] = e;

        return res;
    }
}
