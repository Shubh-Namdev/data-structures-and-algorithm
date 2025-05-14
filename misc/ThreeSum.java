import java.util.Scanner;
import java.util.*;

class ThreeSum {

    public List<List<Integer>> threeSum(Integer[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                int val = -1 * (nums[i]+nums[j]);

                if (map.containsKey(val)) {
                    for (int k : map.get(val)) {
                        result.add(Arrays.asList(k,i,j));
                    }
                }
            }
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        return result;
    }

    public List<List<Integer>> threeSumBrute1(Integer[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<HashSet<Integer>> uq = new ArrayList<>();

        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                HashSet<Integer> set = map.get(key);
                set.add(i);
                map.put(key,set);
            }else {
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                map.put(key,set);
            }
        }

        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                int ts = nums[i] + nums[j];
                int diff = -ts;

                if (map.containsKey(diff)) {
                    HashSet<Integer> set = map.get(diff);
                    if (set.size() > 1) {
                        boolean isExist = false;
                        for (HashSet<Integer> s : uq) {
                            if (s.contains(nums[i]) && s.contains(nums[j]) && s.contains(diff)) {
                                isExist = true;
                            }
                        }
                        if (!isExist) {
                            List<Integer> li = new ArrayList<>();
                            li.add(nums[i]);
                            li.add(nums[j]);
                            li.add(diff);
                            result.add(li);

                            HashSet<Integer> newSet = new HashSet<>();
                            newSet.add(nums[i]);
                            newSet.add(nums[j]);
                            newSet.add(diff);
                            uq.add(newSet);
                        }
                    }else {
                        if (!set.contains(i) && !set.contains(j)) {
                            boolean isExist = false;
                            for (HashSet<Integer> s : uq) {
                                if (s.contains(nums[i]) && s.contains(nums[j]) && s.contains(diff)) {
                                    isExist = true;
                                }
                            }
                            if (!isExist) {
                                List<Integer> li = new ArrayList<>();
                                li.add(nums[i]);
                                li.add(nums[j]);
                                li.add(diff);
                                result.add(li);

                                HashSet<Integer> newSet = new HashSet<>();
                                newSet.add(nums[i]);
                                newSet.add(nums[j]);
                                newSet.add(diff);
                                uq.add(newSet);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSumBrute2(Integer[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<HashSet<Integer>> uq = new ArrayList<>();

        for (int i=0; i<nums.length-2; i++) {
            for (int j=i+1; j<nums.length-1; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    if (nums[i]+nums[j]+nums[k] == 0) {
                        boolean isExist = false;
                        for (HashSet<Integer> set : uq) {
                            if (set.contains(nums[i])&& set.contains(nums[j])&&set.contains(nums[k])) {
                                isExist = true;
                            }
                        }
                        if (!isExist) {
                            List<Integer> li = new ArrayList<>();
                            li.add(nums[i]);
                            li.add(nums[j]);
                            li.add(nums[k]);
                            result.add(li);

                            HashSet<Integer> set = new HashSet<>();
                            set.add(nums[i]);
                            set.add(nums[j]);
                            set.add(nums[k]);
                            uq.add(set);
                        }
                    }
                }
            }
        }
        return result;
    }


    public List<List<Integer>> threeSumAlt(Integer[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i-1 >= 0 && Objects.equals(nums[i], nums[i - 1])) {
                continue;
            }

            int j = i+1, k = nums.length - 1;
            while (j < k) {
                if (j-1 >i && Objects.equals(nums[j], nums[j - 1])) {
                    j++;continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(nums[k]);
                    result.add(tempList);

                    j++;
                } else if (sum > 0) {
                    k--;
                }else{
                    j++;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer []nums = new Integer[n];
        for(int i = 0; i < n ; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        List<List<Integer>> result = new ThreeSum().threeSum(nums);
        for (List<Integer> integers : result) {
            System.out.printf("%d %d %d\n", integers.get(0), integers.get(1), integers.get(2));
        }
    }
};
