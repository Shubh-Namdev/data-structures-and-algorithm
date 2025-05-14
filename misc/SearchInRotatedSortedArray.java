import java.io.*;
import java.util.*;
class SearchInRotatedSortedArray {

    // Complete the function implementation below
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (target > nums[0] && target < nums[pivot]) {
            int s=0, e=pivot;
            while (s <= e) {
                int mid = s + ((e-s)/2);

                if (nums[mid] == target) return mid;
                else if (target > nums[mid]) s=mid+1;
                else e=mid-1;
            }
        }else if (pivot < nums.length-1 && (target > nums[pivot+1] && target < nums[nums.length-1])) {
            int s=pivot+1, e=nums.length-1;
            while (s <= e) {
                int mid = s + ((e-s)/2);

                if (nums[mid] == target) return mid;
                else if (target > nums[mid]) s=mid+1;
                else e=mid-1;
            }
        }else {
            return -1;
        }
        return 0;
    }

    static int findPivot(int []nums) {
        int s=0,e=nums.length-1;
        while ( s < e ) {
            int mid = s + ((e-s)/2);

            if (nums[mid] > nums[mid+1]){
                return mid;
            }

            if (nums[mid] > nums[s]) {
                s = mid;
            }else {
                e = mid;
            }
        }
        return nums.length-1;
    }

    public int searchNAnd1(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for(int i = 0 ; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        while(q > 0) {
            int target = scanner.nextInt();
            int result = new SearchInRotatedSortedArray().search(nums , target);
            System.out.println(result);
            q--;
        }
    }
}


