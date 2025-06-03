import java.util.*;

public class BeesToHives{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> beesPositions = new ArrayList<>();
        ArrayList<Integer> hivesPositions = new ArrayList<>();
        for(int i=0;i<n;i++){
            beesPositions.add(sc.nextInt());
        }
        for(int i=0;i<n;i++){
            hivesPositions.add(sc.nextInt());
        }
        int ans = beesToHives(n,beesPositions,hivesPositions);
        System.out.println(ans);
        sc.close();
    }
    // Implement Your Solution Here
    public static int beesToHives(int n,ArrayList<Integer> beesPositions,ArrayList<Integer> hivesPosition){
        PriorityQueue<Integer> dist = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(beesPositions);
        Collections.sort(hivesPosition);

        for (int i=0; i<n; i++) {
            int d = Math.abs(beesPositions.get(i) - hivesPosition.get(i));
            dist.add(d);
        }

        return dist.peek();
    }
}
