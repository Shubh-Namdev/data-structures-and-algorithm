import java.util.*;


class ReverseBits{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while(t-->0){
            long n = sc.nextLong();
            long ans = reverseBits(n);
            System.out.println(ans);
        }
    }

    static long reverseBits(long n){
        //signed 32 bit integer so we can mark right as 0 and left as 31
        int right=0, left=31;
        //answer to be returned as long
        long answer = 0;

        //run the loop to iterate over the complete integer
        while (left > right) {
            //left bit is set or not
            if (checkSetBit(n,left) == true) {
                answer = setBit(answer,right);
            }
            //right bit is set or not
            if (checkSetBit(n,right) == true) {
                answer = setBit(answer,left);
            }

            //update the bits
            left--;
            right++;
        }
        return answer;
    }

    static boolean checkSetBit(long n, int bit) {
        //create mask
        long mask = (1l << bit);
        //check if ops equal to 1
        if ((n & mask) == 0) return false;
        else return true;
    }

    static long setBit(long n, int bit) {
        //create mask
        long mask = (1l << bit);
        return (n | mask);
    }
}
