public class MoveZeroToRight {

    public static int[] moveZeros(int []a) {
        int count = 0;
        int i=0;
        while (i < a.length-count) {
            if (a[i] == 0) {
                int j=i;
                while (j < a.length-count-1) {
                    a[j] = a[j+1];
                    j++;
                }
                a[j] = 0;
                count++;
            }else {
                i++;
            }
        }
        return a;
    }
    public static void main(String[] args) {
        int []a = moveZeros(new int[]{2,1,0,4,2,0,0,5});
        for (int val : a) {
            System.out.print(val+" ");
        }
    }
}
