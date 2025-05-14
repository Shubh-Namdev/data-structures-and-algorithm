import java.util.*;

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return Math.abs(a) - Math.abs(b);
    }
}

class SortArrayAbsolute {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int res[] = sortArrayAbsolute(n, arr);

        for (int j : res)
            System.out.print(j + " ");
    }

    static int[] sortArrayAbsolute(int n, int arr[]) {
        Integer []a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = arr[i];
        }
        Arrays.sort(a,new MyComparator());

        for (int i = 0; i < n; i++) {
            arr[i] = a[i];
        }
        return arr;
    }

    static int[] sortArrayAbsoluteMine(int n, int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            if (arr[i] < 0) {
                if (map.containsKey(-arr[i])) {
                    map.put(-arr[i],map.get(-arr[i])+1);
                }else {
                    map.put(-arr[i], 1);
                }
                arr[i] = -arr[i];
            }
        }

        int []sorted = sort(arr,0,n-1);
        for (int i=0; i<n; i++) {
            if (map.containsKey(sorted[i])) {
                if (map.get(sorted[i]) > 1) {
                    map.put(sorted[i], map.get(sorted[i])-1);
                }else {
                    map.remove(sorted[i]);
                }
                sorted[i] = -sorted[i];
            }
        }
        return sorted;
    }

    static int[] sort(int[] arr, int s, int e) {
        if (s == e) {
            return new int[]{arr[s]};
        }

        int mid = (s+e)/2;
        int []left = sort(arr,s,mid);
        int []right = sort(arr,mid+1,e);

        return merge(left,right);
    }

    static int[] merge(int []left, int []right) {
        int n = left.length;
        int m = right.length;

        int []merged = new int[n+m];
        int l=0,r=0,c=0;
        while (l < n && r < m) {
            if (left[l] < right[r]) {
                merged[c] = left[l];
                l++;
                c++;
            }else {
                merged[c] = right[r];
                r++;
                c++;
            }
        }

        while (l < n) {
            merged[c] = left[l];
            l++;
            c++;
        }

        while (r < m) {
            merged[c] = right[r];
            r++;
            c++;
        }
        return merged;
    }

    static int[] sortArrayAbsoluteNN(int n, int arr[]) {
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                int num1 = arr[i], num2=arr[j];
                if (num1 < 0 && num2 < 0){
                    num1 = -(num1);
                    num2 = -(num2);
                }else if (num1 < 0){
                    num1 = -(num1);
                }else if (num2 < 0){
                    num2 = -(num2);
                }

                if (num2 < num1) {
                    swap(arr,i,j);
                }
            }
        }
        return arr;
    }

    static void swap(int a[],int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
