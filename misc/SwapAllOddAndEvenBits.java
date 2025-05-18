import java.io.*;
import java.util.*;

class SwapAllOddAndEvenBits {

    // Complete the function below

    public long swapBits(long n) {
        for (int i=0; i<32; i+=2) {
            long ith = ((n >> i)&1);
            long ith_1 = ((n >> i+1)&1);

            n = n - (ith << i) - (ith_1 << (i+1));
            n = n + (ith << (i+1)) + (ith_1 << i);
        }
        return n;
    }

    public long swapBitsAlt(long n) {
        long i=0;
        while (i < 32) {
            long mask1 = (1L << (i));
            long mask2 = (1L << (i+1));

            long a = (n & mask1);
            long b = (n & mask2);

            if (a != b) {
                n = (n ^ mask1);
                n = (n ^ mask2);
            }

            i += 2;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();
        long result = new SwapAllOddAndEvenBits().swapBits(n);
        System.out.println(result);
    }
}
