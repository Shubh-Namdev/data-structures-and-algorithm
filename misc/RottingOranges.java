import java.util.*;

class RottingOranges{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while((t--)>0){
            int n,m;
            n= sc.nextInt();
            m=sc.nextInt();
            ArrayList<ArrayList<Integer> > a = new ArrayList<ArrayList<Integer> >();
            for(int i=0;i<n;i++){
                a.add(new ArrayList<Integer>());
            }
            for(int i=0;i<n;i++){
                for(int j = 0;j<m;j++){
                    a.get(i).add(sc.nextInt());
                }
            }
            int ans  = RottingOranges.rottingOranges(a);
            System.out.println(ans);
        }
        sc.close();
    }

    public static int rottingOranges(ArrayList<ArrayList<Integer>> a){
        int n = a.size();
        int m = a.get(0).size();

        Queue<int[]> ro = new LinkedList<>();
        int fo = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a.get(i).get(j) == 2) {
                    ro.add(new int[]{i,j});
                }else if (a.get(i).get(j) == 1) {
                    fo++;
                }
            }
        }

        int t = 0;
        while (!ro.isEmpty()) {
            int []rc = ro.remove();
            int r = rc[0];
            int c = rc[1];

            int [][]directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
            for (int []direction : directions) {
                int rIdx = direction[0]+r;
                int cIdx = direction[1]+c;

                if (rIdx >= 0 && rIdx < n && cIdx >= 0 && cIdx < m && a.get(rIdx).get(cIdx) == 1) {
                    a.get(rIdx).set(cIdx, 2);
                    ro.add(new int[]{rIdx, cIdx});
                    fo--;
                }
            }
            t++;
        }
        if (fo > 0) return -1;
        return t;
    }
}
