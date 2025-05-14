import java.lang.reflect.Array;
import java.util.*;

public class MeetingRooms {

    //complexity -> nlogn
    public int findNumRooms(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> endPq = new PriorityQueue<>();

        int room = 1;

        for (int i=0; i<intervals.length; i++) {
            endPq.add(intervals[i][1]);
        }

        for (int i=1; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = endPq.peek();

            if (start < end) {
                room++;
            }else {
                endPq.remove();
            }
        }
        return room;
    }

    public int findNumRooms2(int[][] intervals) {
        PriorityQueue<Integer> endPq = new PriorityQueue<>();
        PriorityQueue<Integer> stPq = new PriorityQueue<>(Collections.reverseOrder());
        int room = 1;

        for (int i=0; i<intervals.length; i++) {
            endPq.add(intervals[i][1]);
            stPq.add(intervals[i][0]);
        }

        for (int i=0; i<intervals.length; i++) {
            int st1 = intervals[i][0];
            int e1 = intervals[i][1];

            if (!(st1 >= endPq.peek()) && !(stPq.peek() >= e1)) {
                room++;
            }

            if (st1 >= endPq.peek()) {
                endPq.remove();
            }
            if (stPq.peek() >= e1) {
                stPq.remove();
            }

        }
        return room;
    }

    public int findNumRooms1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int room = 1;
        List<Integer> li = new ArrayList<>();
        li.add(intervals[0][1]);

        for (int i=1; i< intervals.length; i++ ) {
            int j=0;
            while ( j < li.size()) {
                if (intervals[i][0] >= li.get(j)) {
                   li.remove(j);
                   li.add(intervals[i][1]);
                   break;
                }
                j++;
            }
            if ( j == li.size()) {
                room++;
                li.add(intervals[i][1]);
            }
        }
        return room;
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

        int result = new MeetingRooms().findNumRooms(nums);

        System.out.printf("%d", result);
    }

}
