import java.util.*;


class DistinctNumbersBasic{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int []nums = new int[n];
        for(int i=0;i<n;i++)
            nums[i] = sc.nextInt();

        //int res = DistinctNumbers(n,nums);
        //int res = DistinctNumbersInSortedArr(n,nums);
        int repeated = firstRepeating(n,nums);
        int unique = firstUnique(n,nums);
        System.out.println(repeated);
        System.out.println(unique);
    }

    static int DistinctNumbers(int n,int []nums){
        HashMap<Integer,String> map = new HashMap<>();

        int i=0;
        while (i < n) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i],Integer.toString(nums[i]));
            }
            i++;
        }
        return map.size();
    }

    static int firstRepeating(int n,int []nums) {
        HashSet<Integer> set = new HashSet<>();

        int i=0;
        while(i < n) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
            i++;
        }
        return -1;
    }

    static int firstUnique(int n,int []nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int i=0;
        while(i < n) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            }else {
                map.put(nums[i],i);
            }
            i++;
        }

        int firstUniqKeyIndex = Integer.MAX_VALUE;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() < firstUniqKeyIndex) {
                firstUniqKeyIndex = entry.getValue();
            }
        }
        return nums[firstUniqKeyIndex];
    }

    static int DistinctNumbersInSortedArr(int n,int []nums){
        int i=0,count=1;
        while (i < n-1) {
            if (nums[i] == nums[i+1]) {
                i++;
            }else {
                count++;
                i++;
            }
        }
        return count;
    }

    static int DistinctNumbers1(int n,int nums[]){
        Integer []temp = new Integer[n];
        int k=0;

        for (int i=0; i<n; i++) {
            int j=0;
            boolean isExist = false;
            while (j < n) {
                if (nums[i] == temp[j]) {
                    isExist = true;
                }
                j++;
            }
            if (isExist) {
                temp[k] = nums[i];
                k++;
            }
        }

        k =0;
        int count = 0;
        while (k < temp.length) {
            if (temp[k] != null) {
                count++;
            }
            k++;
        }

        return count;
    }
}