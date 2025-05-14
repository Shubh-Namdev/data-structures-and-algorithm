import java.util.*;

class CountVowels {
    // NOTE: Please do not modify this function
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int vowels = countVowels(str);
        System.out.println(vowels);
    }

    // TODO: Implement this method
    static int countVowels(String str) {
        //char []temp = str.toCharArray();
        int count = 0;

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == 65 || str.charAt(i) == 69 ||
                    str.charAt(i) == 73 || str.charAt(i) == 79 ||
                    str.charAt(i) == 85 || str.charAt(i) == 97 ||
                    str.charAt(i) == 101 || str.charAt(i) == 105 ||
                    str.charAt(i) == 111 || str.charAt(i) == 117) {
                count++;
            }
        }
        return count;
    }

    static int countVowels1(String str) {
        char []temp = str.toCharArray();
        int count = 0;

        for (int i=0; i<temp.length; i++) {
            if (temp[i] == 65 || temp[i] == 69 ||
                    temp[i] == 73 || temp[i] == 79 ||
                    temp[i] == 85 || temp[i] == 97 ||
                    temp[i] == 101 || temp[i] == 105 ||
                    temp[i] == 111 || temp[i] == 117) {
                     count++;
            }
        }
        return count;
    }
}
