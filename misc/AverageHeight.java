import java.util.*;


class AverageHeightBasic{
    // NOTE: Please do not modify this function
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float a[] = new float[n];

        for(int i = 0; i < n; i++)
        {
            a[i] = Float.parseFloat(sc.next());
        }

        float avgHeight = averageHeight(n, a);
        System.out.println(avgHeight);
    }

    // TODO: Implement this method
    static float averageHeight(int n, float[] a){
        int i = 0;
        float sum = 0;
        while (i < n) {
            sum += a[i];
            i++;
        }

        float average = sum/n;
        double roundedNum = Math.round(average * Math.pow(10,5))/Math.pow(10,n);

        return (float)roundedNum;
    }
}
