import java.util.*;


class DecimalToBinary{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int res = decimalToBinary(n);
        int res = binaryToDecimal("10001000");
        System.out.println(res);
    }
    static int binaryToDecimal(String B){
        int len = B.length();
        int p =0,decimal=0;
        for (int i= len-1; i>=0; i--) {
            int res = (int)Math.pow(2,p);
            int val = Integer.parseInt(String.valueOf(B.charAt(i)));
            int sum = val * res;
            decimal = decimal + sum;
            p++;
        }
        return decimal;
        /*
        if ( B.isEmpty() ) return Integer.MIN_VALUE;

        int num = Integer.parseInt(B);
        int decimal = 0;

        int p=0;
        while (num != 0) {
            int rem = num % 10;
            int res = rem * ((int)Math.pow(2,p));
            decimal = decimal + res;

            num /= 10;
            p++;
        }
        return decimal;
         */
    }

    static int decimalToBinary(int n){
        String res = "";
        while(n != 0) {
            int rem = n % 2;
            res += rem;
            n = n/2;
        }

        char []rev = res.toCharArray();
        int i=0,j= rev.length-1;
        while(i < j) {
            char temp = rev[i];
            rev[i] = rev[j];
            rev[j] = temp;

            i++;
            j--;
        }

        return Integer.parseInt(String.valueOf(rev));
    }
}