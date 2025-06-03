import java.util.*;


class MergeKSortedArrays{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();
            ArrayList<Integer> array = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                array.add(sc.nextInt());
            }
            arrays.add(array);
        }
        ArrayList<Integer> ans = mergeKSortedArrays(arrays);
        for (Integer x: ans) {
            System.out.print(x + " ");
        }
    }

    static class Pair implements Comparable<Pair> {
        int elem, arrIdx, elemIdx;

        public Pair(int elem, int arrIdx, int elemIdx) {
            this.elem = elem;
            this.arrIdx = arrIdx;
            this.elemIdx = elemIdx;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.elem, other.elem);
        }
    }

    static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> arrays){
        ArrayList<Integer> ans = new ArrayList<Integer>();

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i=0; i<arrays.size(); i++) {
            pq.add(new Pair(arrays.get(i).get(0), i, 0));
        }

        while (!pq.isEmpty()) {
            Pair cur = pq.remove();
            ans.add(cur.elem);

            if (cur.elemIdx+1 < arrays.get(cur.arrIdx).size()) {
                int newIdx = cur.elemIdx + 1;
                int newElem = arrays.get(cur.arrIdx).get(newIdx);
                pq.add(new Pair(newElem, cur.arrIdx, newIdx));
            }
        }

        return ans;
    }
}
