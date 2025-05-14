import java.util.*;

class GcdBasic {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            long a = sc.nextLong();
            long b = sc.nextLong();

            long res = gcd(a, b);
            System.out.println(res);

        }
    }

    static long gcd(long a, long b) {
        //find min of a,b
        long minOne = (long)Math.sqrt(Math.min(a,b));
        //create an array to store factors of a,b
        long []gcd = new long[(int)minOne];
        int j=0;
        //run a loop till minOne
        for (int i=1; i<=minOne; i++) {
            if (a%i == 0 && b%i == 0) {
                gcd[j] = i;
                j++;
            }
        }
        //iterate over gcd array to find the largest number
        long max = Integer.MIN_VALUE;
        for (long l : gcd) {
            if (l > max) {
                max = l;
            }
        }

        return max;

    }
}