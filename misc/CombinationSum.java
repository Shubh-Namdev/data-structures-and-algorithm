import java.util.*;

class CombinationSum{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] candidates = new int[n];
        for(int i=0;i<n;i++){
            candidates[i] = sc.nextInt();
        }
        List<List<Integer>>res = combinationSum(candidates, target);
        if(res.size()==0){
            System.out.println("NA\n");
        }
        else{
            for(int i=0;i<res.size();i++){
                for(int j=0;j<res.get(i).size();j++){
                    System.out.print(res.get(i).get(j)+" ");
                }
                System.out.print("\n");
            }
        }
        sc.close();
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        sumSets(0, target, candidates, res, new ArrayList<>());
        return res;
    }

    static void sumSets(int i, int target,int []candidates, List<List<Integer>> res, List<Integer> ds) {
        if (i == candidates.length ) {
            if (target == 0) res.add(new ArrayList<>(ds));
            return;
        }

        if (candidates[i] <= target){
            ds.add(candidates[i]);
            sumSets(i, target-candidates[i], candidates, res, ds);
            ds.remove(ds.size()-1);
        }
        sumSets(i+1, target, candidates, res, ds);
    }

}
