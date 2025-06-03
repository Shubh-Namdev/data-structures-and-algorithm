import java.util.*;


class MinimumPlatforms{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int arrival[]=new int[n];
        int departure[]=new int[n];

        for(int i=0;i<n;i++)
        {
            arrival[i]=sc.nextInt();
            departure[i]=sc.nextInt();
        }
        System.out.println(minimumPlatforms(n,arrival,departure));

    }

    static class TrainSchedule{
        int arrivalTime;
        int departureTime;

        TrainSchedule(int a, int d) {
            this.arrivalTime = a;
            this.departureTime = d;
        }

        public String toString() {
            return "["+this.arrivalTime+","+this.departureTime+"]";
        }
    }

    static class ScheduleOfTrain implements Comparator<TrainSchedule> {
        @Override
        public int compare(TrainSchedule s1, TrainSchedule s2) {
            return s1.departureTime - s2.departureTime;
        }
    }

    static int minimumPlatformsOther(int n, int arrival[], int departure[]){
        /*
        PriorityQueue<TrainSchedule> schedule = new PriorityQueue<>(new ScheduleOfTrain());
        for (int i=0; i<n; i++) {
            schedule.add(new TrainSchedule(arrival[i], departure[i]));
        }
         */
        int [][]schedule = new int[n][];
        for (int i=0; i<n; i++) {
            schedule[i] = new int[]{arrival[i],departure[i]};
        }
        Arrays.sort(schedule, Comparator.comparingInt(obj -> obj[1]));
        for (int []sc : schedule) {
            System.out.print("["+sc[0]+","+sc[1]+"]");
        }
        System.out.println();


        int platformCount = 1;
        int []prev = schedule[0];
        int i=1,j=1;
        while (i < n) {
            int []cur = schedule[i];

            if (cur[0] > prev[1]) {
                prev = schedule[j];
                j++;
            }else {
                platformCount++;
            }
            i++;
        }

        return platformCount;
    }

    static int minimumPlatforms(int n, int arrival[], int departure[]) {
        int res = 0;

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int j = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {

            while (j < n && departure[j] < arrival[i]) {
                cnt--;
                j++;
            }

            cnt++;
            res = Math.max(res, cnt);
        }

        return res;
    }
}
