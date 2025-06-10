import java.util.*;

class KnightWalk{


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int starting_pos[]=new int[2];
        int ending_pos[]=new int[2];
        starting_pos[0]=sc.nextInt();
        starting_pos[1]=sc.nextInt();
        ending_pos[0]=sc.nextInt();
        ending_pos[1]=sc.nextInt();
        System.out.println(knightWalk(starting_pos,ending_pos,n));

    }

    static int knightWalk(int starting_pos[], int ending_pos[], int n){
        int []dx = {-2,-1,1,2,-2,-1,1,2};
        int []dy = {-1,-2,-2,-1,1,2,2,1};

        boolean [][]visited = new boolean[n+1][n+1];
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n; j++) {
                visited[i][j] = false;
            }
        }
        visited[starting_pos[0]][starting_pos[1]] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{starting_pos[0], starting_pos[1], 0});

        while (!q.isEmpty()) {
            int []points = q.remove();
            if (points[0]==ending_pos[0] && points[1]==ending_pos[1])
                return points[2];

            for (int i=1; i<=8; i++) {
                int x = points[0]+dx[i];
                int y = points[1]+dy[i];
                int curDistance = points[2];

                if (isValidPos(x, y, n) && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new int[]{x, y, curDistance+1});
                }
            }
        }
        return -1;
    }

    static boolean isValidPos(int x, int y, int n) {
        return x >= 1 && y >=1 && x <= n && y <= n;
    }
}
