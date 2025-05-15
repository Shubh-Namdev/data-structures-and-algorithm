import java.util.*;

public class FormLargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        long num = formLargest(a);
        System.out.println(num);
    }

    static long formLargest(int []a) {
        long res = 0;
        List<String> list = new ArrayList<>();
        for (int val : a) {
            list.add(String.valueOf(val));
        }

        list.sort((s1, s2) -> myCompare(s1, s2) ? -1 : 1);
        if (list.getFirst().equals("0")) return 0;

        for (String s : list) {
            int num = Integer.parseInt(s);
            int p = (int)Math.log10(num)+1;
            int pow10 = (int)Math.pow(10,p);
            res = (res * pow10) + num;
        }
        return res;
    }

    static boolean myCompare(String s1, String s2) {
        return (s1+s2).compareTo(s2+s1) > 0;
    }

    static long formLargestNMaxLogNAnd1(int []a) {
        Integer []arr = new Integer[a.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[i];
        }
        Arrays.sort(arr,new MyComparision());

        long res = 0;
        for (Integer val : arr) {
            int p = (int)Math.log10(val) +1;
            int pow10 = (int)Math.pow(10,p);
            res = (res * pow10) + val;
        }
        return res;
    }

}

class MyComparision implements Comparator<Integer> {
    @Override
    public int compare(Integer v1, Integer v2) {
        int v1Dig = (int)Math.log10((double)v1);
        int v2Dig = (int)Math.log10((double)v2);

        if (v1Dig == v2Dig) return v2-v1;

        String s1 = String.valueOf(v1);
        String s2 = String.valueOf(v2);

        int n = Math.min(s1.length(),s2.length());
        int i=0;
        while (i < n) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if (ch1 > ch2) return -1;
            if (ch2 > ch1) return 1;

            i++;
        }

        int v1Ascii = 0,v2Ascii=0;
        int j=0;
        while (j < s1.length()) {
            char ch = s1.charAt(j);
            v1Ascii += (ch-48);
            j++;
        }

        int k=0;
        while (k < s2.length()) {
            char ch = s2.charAt(k);
            v2Ascii += (ch-48);
            k++;
        }

        if (v1Ascii == v2Ascii) return Math.min(v1,v2);
        return Integer.compare(v2Ascii, v1Ascii);
    }
}

