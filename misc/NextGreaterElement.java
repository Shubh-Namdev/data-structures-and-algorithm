import java.util.*;
class NextLargerElement {

    static int [] nextLargerElement(int nums[], int n) {
        List<Integer> li = new ArrayList<>();

        for (int i=0; i<n-1; i++) {
            boolean isExist = false;
            for (int j=i+1; j<n; j++) {
                if (nums[j] > nums[i]) {
                    li.add(nums[j]);

                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                li.add(-1);
            }
        }
        li.add(-1);

        int []res = new int[li.size()];
        for (int i=0; i< res.length; i++) {
            res[i] = li.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        int [] ans = nextLargerElement(ar, n);
        for (int i = 0; i < ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}