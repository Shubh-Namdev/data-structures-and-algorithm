import java.util.*;


class WiggleSort{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }
        List<Integer>ans = wiggleSort(n,nums);
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i)+" ");
        }
    }

    static List<Integer> wiggleSort(int n, List<Integer>nums){
        int i=0;
        while (i < nums.size()-1) {
            if (i % 2 == 0) {
                if (nums.get(i) >= nums.get(i+1)){
                    int temp = nums.get(i);
                    nums.add(i,nums.get(i+1));
                    nums.add(i+1,temp);
                }
            }else {
                if (nums.get(i) <= nums.get(i+1)) {
                    int temp = nums.get(i);
                    nums.add(i,nums.get(i+1));
                    nums.add(i+1,temp);
                }
            }
            i++;
        }
        return nums;
    }

    static List<Integer> wiggleSortNLogNAndN(int n, List<Integer>nums){
        List<Integer> li = new ArrayList<>();
        Collections.sort(nums);

        int i=0,j=0,k=nums.size()%2 == 0 ? nums.size()/2 : (nums.size()/2)+1;
        while (i < nums.size()) {
            if (i % 2 == 0) {
                li.add(nums.get(j));
                j++;
            }else {
                li.add(nums.get(k));
                k++;
            }
            i++;
        }
        return li;
    }
}
