import java.util.*;


class JobSequencing{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int deadlines[]=new int[n];
        int profits[]=new int[n];

        for(int i=0;i<n;i++)
        {
            deadlines[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            profits[i]=sc.nextInt();
        }

        System.out.println(jobSequencing(n, deadlines, profits));
    }

    static int jobSequencing(int n, int deadlines[], int profits[]){
        PriorityQueue<int[]> jobs = new PriorityQueue<>(Comparator.comparingInt(obj -> -obj[0]));
        for (int i=0; i<n; i++) {
            jobs.add(new int[]{profits[i], deadlines[i]});
        }

        ArrayList<int[]> li = new ArrayList<>();
        while (!jobs.isEmpty()) {
            li.add(jobs.remove());
        }

        int maxProfit = 0;
        while (!li.isEmpty()) {
            int []job = li.remove(0);
            maxProfit += job[0];

            int i=0;
            while (i < li.size()) {
                int temp[] = li.remove(0);
                if (temp[1] > 1) li.add(new int[]{temp[0], temp[1]-1});
                i++;
            }
        }

        return maxProfit;
    }
}
