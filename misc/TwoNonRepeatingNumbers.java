import java.util.*;

class TwoNonRepeatingNumbers{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int ans[] = twoNonRepeatingNumbers(nums);
        System.out.println(ans[0]+" "+ans[1]);
        sc.close();
    }

    static int[] twoNonRepeatingNumbers(int[] nums) {
        int []res = new int[2];
        int xor = 0;
        for (int num : nums) {
            xor += xor^num;
        }

        int pos = 0;
        while (true) {
            if (((xor>>pos)&1) == 1) {
                break;
            }
            pos++;
        }

        for (int num : nums) {
            if (((num>>pos)&1) == 1) {
                res[0] = res[0]^num;
            }else {
                res[1] = res[1]^num;
            }
        }
        Arrays.sort(res);
        return res;
    }
}
