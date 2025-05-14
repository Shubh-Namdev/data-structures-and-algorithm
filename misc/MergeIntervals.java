import java.util.*;

class MergeIntervals {

    public int[][] mergeIntervals(int[][] intervals) {
        List<int[]> li = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        int j=0,r=1;
        while (r < intervals.length) {
            if (intervals[r][0] <= end) {
                end = Math.max(end,intervals[r][1]);
                r++;
            }else {
                li.add(new int[]{start,end});

            }
        }
        li.add(new int[]{start,end});
        return li.toArray(new int[li.size()][]);
    }


    public int[][] mergeIntervalsMine(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a -> a[0]));
        Stack<int[]> stk = new Stack<>();
        stk.push(intervals[0]);

        int r=1;
        while (r < intervals.length) {
            int start = intervals[r][0];
            int []endArr = stk.peek();
            int end = endArr[1];

            if (start <= end) {
                stk.pop();

                endArr[1] = Math.max(end,intervals[r][1]);
                stk.push(endArr);
            }else {
                stk.push(intervals[r]);
            }
            r++;
        }

        int [][]res = new int[stk.size()][2];
        int j= res.length-1;
        while (j >= 0) {
            res[j] = stk.pop();
            j--;
        }

        return res;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] nums = new int[n][2];

        for(int i = 0 ; i < n ;i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }

        int[][] results = new MergeIntervals().mergeIntervals(nums);

        for (int[] result : results) {
            System.out.printf("%d %d\n", result[0], result[1]);
        }
    }
}
