import java.io.*;
import java.util.*;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length - 1; i++) {
            for (int j=i+1; j<=nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                   return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public int[] twoSumBetterSol(int[] nums, int target) {
        int l = 0,r =nums.length-1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                return new int[]{l,r};
            }else if (nums[l] + nums[r] > target) {
                r--;
            }else {
                l++;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[scanner.nextInt()];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = scanner.nextInt();
        int target = scanner.nextInt();
        scanner.close();

        int[] complements = new TwoSum().twoSumBetterSol(numbers, target);
        System.out.print(complements[0] + " " + complements[1]);
    }
}