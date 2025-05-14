import java.util.*;

class DiamondPrintingBasic {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] pattern = diamondPrinting(n);

        for (int i = 0; i < 2 * n - 1; i++)
            System.out.println(pattern[i]);

    }

    // TODO: Implement this method
    static String[] diamondPrinting(int n) {
        String []pattern = new String[2*n-1];
        System.out.println(pattern);
        int k=0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                pattern[k] += "* ";
            }
            k++;
        }


        for (int i=n-2; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                pattern[k] += "* ";
            }
            k++;
        }
        for (int i = 0; i < pattern.length; i++) {
            System.out.println(pattern[i]);
        }
        return pattern;
    }
}