import java.util.*;


class FractionalKnapsack{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n,w;
        n=sc.nextInt();
        w=sc.nextInt();

        int wt[]=new int[n];
        int val[]=new int[n];
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        System.out.println(String.format("%.6f",fractionalKnapsack(n,w,wt,val)));
    }

    static class ItemValue {
        Double cost;
        double wt, val, ind;

        public ItemValue(int wt, int val, int ind)
        {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = ((double)val/(double)wt);
        }
    }

    static double fractionalKnapsack(int n, int capacity, int[] wt, int[] val){
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(obj -> -obj[0]));

        for (int i=0; i<n; i++) {
            double perKgVal = ((double)val[i]/(double)wt[i]);
            pq.add(new double[]{perKgVal, (double)wt[i]});
        }
        System.out.println(pq);

        double res = 0;
        while (capacity > 0) {
            double []cost = pq.remove();
            double itemWeigh = cost[1];
            if (itemWeigh >= capacity) {
                res += (capacity*cost[0]);
                capacity = 0;
            }else {
                res += (itemWeigh*cost[0]);
                capacity -= (int)itemWeigh;
            }
        }

        return res;
    }



}
