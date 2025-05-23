import java.util.*;

class CountDistinctElements {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        ArrayList<Integer> res = countDistinctElements(n, b, arr);

        for (int j : res)
            System.out.print(j + " ");

    }

    static ArrayList<Integer> countDistinctElements(int N, int B, int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i=0; i<B; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        res.add(map.size());

        for (int i=B; i<=N-B+1; i++) {
            int elemTORemove = arr[i-B];
            if (map.get(elemTORemove) > 1) {
                map.put(elemTORemove,map.get(elemTORemove)-1);
            }else {
                map.remove(elemTORemove);
            }

            int elemToAdd = arr[i];
            if (map.containsKey(elemToAdd)) {
                map.put(elemToAdd,map.get(elemToAdd)+1);
            }else {
                map.put(elemToAdd,1);
            }

            res.add(map.size());
        }
        return res;
    }

    static ArrayList<Integer> countDistinctElementsBrute(int N, int B, int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int i=0; i<((N-B)+1); i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j=i; j<(i+B); j++) {
                set.add(arr[j]);
            }
            res.add(set.size());
        }
        return res;
    }
}
