import java.util.*;

class CloseComparator implements Comparator<long[]> {
    @Override
    public int compare(long []o1, long []o2) {
        long d1 = Math.abs(o1[0]) + Math.abs(o1[1]);
        long d2 = Math.abs(o2[0]) + Math.abs(o2[1]);

        if (d1 < d2) return -1;
        else if (d2 < d1) return 1;
        return 0;
    }
}
class KClosestPointsToOrigin {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long[][] points = new long[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextLong();
            points[i][1] = sc.nextLong();
        }
        long[][] ans = kClosestPointsToOrigin(points, k);
        for (int i = 0; i < k; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }

    public static long[][] kClosestPointsToOrigin(long[][] points, int k) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingDouble(obj -> -Math.sqrt(Math.pow(obj[0],2) + Math.pow(obj[1], 2))));

        for (int i=0; i<k; i++) {
            pq.add(points[i]);
        }

        for (int i=k; i<points.length; i++) {
            double curDistance = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            double topDistance = Math.sqrt(Math.pow(pq.peek()[0], 2) + Math.pow(pq.peek()[1], 2));

            if (curDistance < topDistance) {
                pq.remove();
                pq.add(points[i]);
            }
        }

        int idx = 0;
        long [][]res = new long[k][2];
        while (!pq.isEmpty()) {
            res[idx] = pq.remove();
            idx++;
        }
        return res;
    }

    public static long[][] kClosestPointsToOriginOther(long[][] points, int k) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Collections.reverseOrder(new CloseComparator()));

        pq.addAll(Arrays.asList(points));

        long [][]res = new long[k][];
        for (int i=0; i<k; i++) {
            res[i] = pq.remove();
        }
        return res;
    }
}
