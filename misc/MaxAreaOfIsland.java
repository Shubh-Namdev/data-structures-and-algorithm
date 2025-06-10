import java.util.*;
import java.io.*;


class MaxAreaOfIsland{


    public static int maxAreaOfIsland(ArrayList<ArrayList<Integer> > grid){
        int r = grid.size();
        int c = grid.get(0).size();

        int max = Integer.MIN_VALUE;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (grid.get(i).get(j) == 1) {
                    int area = dfs(r, c, i, j, grid);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    static int dfs(int r, int c, int i, int j, ArrayList<ArrayList<Integer>> grid) {
        if (i<0 || i>=r || j<0 || j>=c || grid.get(i).get(j) != 1) return 0;

        grid.get(i).set(j, 2);
        int left = dfs(r, c, i, j-1, grid);
        int right = dfs(r, c, i, j+1, grid);
        int up = dfs(r, c, i-1, j, grid);
        int down = dfs(r, c, i+1, j, grid);

        return left+right+up+down+1;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n,m;

        n = sc.nextInt();
        m = sc.nextInt();

        ArrayList<ArrayList<Integer> > a = new ArrayList<ArrayList<Integer> >();
        for(int i=0;i<n;i++){
            ArrayList<Integer> b = new ArrayList<>();

            for(int j = 0;j<m;j++){
                b.add(sc.nextInt());
            }
            a.add(b);
        }

        int ans = MaxAreaOfIsland.maxAreaOfIsland(a);
        System.out.println(ans);
    }

}
