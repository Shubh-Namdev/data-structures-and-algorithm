import java.util.*;

class Conversion{
    public static int conversion(long A,long B){
        int count = 0;
        int i = 0;

        while (i < 32) {
            long a = (A & 1L);
            long b = (B & 1L);

            if (a != b) count++;

            A = A >> 1L;
            B = B >> 1L;

            i++;
        }
        return count;
    }

    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong();
        long b=sc.nextLong();
        System.out.println(conversion(a,b));
    }
}
