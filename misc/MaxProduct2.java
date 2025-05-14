import java.util.*;


class MaxProduct2{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int nums[] = new int[n];
        for(int i=0;i<n;i++)
            nums[i] = sc.nextInt();

        int res = maxProduct2(n,nums);
        System.out.println(res);
    }

    static int maxProduct2(int n,int nums[]){
        int max1 = 0,max1Index=0;

        int i = 0;
        while (i < n) {
            if (nums[i] > max1) {
                max1 = nums[i];
                max1Index = i;
            }
            i++;
        }
        nums[max1Index] = -1;

        int max2 = 0,max2Index=0;

        i = 0;
        while (i < n) {
            if (nums[i] > max2) {
                max2 = nums[i];
            }
            i++;
        }

        return ((max1-1)*(max2-1));
    }
}
