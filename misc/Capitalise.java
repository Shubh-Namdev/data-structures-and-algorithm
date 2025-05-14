import java.util.*;

class Capitalise {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String captStr = capitalise(str);
        System.out.println(captStr);
    }

    // TODO: Implement this method
    static String capitalise(String str) {
        char []para = str.toCharArray();

        int i=0;
        while(i < para.length) {
            if (para[i] >= 97 && para[i] <= 122) {
                if (i == 0 || para[i-1] == 32) {
                    para[i] = (char) (para[i] - 32);
                }
            }
            i++;
        }

        return new String(para);
    }

}