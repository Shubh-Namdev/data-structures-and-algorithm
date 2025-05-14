import java.util.*;


class KthSmallestElementInMatrix{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<ArrayList<Integer>>Matrix = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer>row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }
            Matrix.add(row);
        }
        int ans = kthSmallestElementInMatrix(Matrix,k);
        System.out.print(ans);
    }

    static int kthSmallestElementInMatrix(List<ArrayList<Integer>>Matrix, int k){
        int ans = 0;
        int s = Matrix.get(0).get(0);
        int e = Matrix.get(Matrix.size()-1).get(Matrix.size()-1);

        while (s <= e) {
            int mid = s + ((e-s)/2);
            if (elemCountLEQToMid(Matrix,k) >= k) {
                ans = mid;
                e = mid-1;
            }else {
                s = mid + 1;
            }
        }
        return ans;
    }

    static int elemCountLEQToMid(List<ArrayList<Integer>>Matrix, int k) {
        int count = 0;
        int n = Matrix.size();
        int i = 0;
        int j = n-1;
        while (i<n && j>=0) {
            while (j>=0 && Matrix.get(i).get(j) > k) {
                j--;
            }
            count += (j+1);
            i++;
        }
        // for (int i=0; i<Matrix.size(); i++) {
        //     count += findCount(Matrix.get(i),k);
        // }
        return count;
    }

    static int findCount(List<Integer> li,int k) {
        int s=0,e=li.size()-1;
        while (s <= e) {
            int mid = s + ((e-s)/2);
            if (li.get(mid) == k) return mid+1;
            else if (li.get(mid) > k) e=mid-1;
            else s=mid+1;
        }
        return 0;
    }
}
