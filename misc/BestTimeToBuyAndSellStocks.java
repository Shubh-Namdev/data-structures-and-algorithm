import java.io.*;
import java.util.*;

public class BestTimeToBuyAndSellStocks {
    // Implement your solution Here
    public int maxProfit(int[] prices) {
        int buy=Integer.MAX_VALUE;
        int maxProfit = 0;

        int i=0;
        while (i < prices.length-1) {
            if ( prices[i+1] < prices[i] ) {
                if ( buy != Integer.MAX_VALUE ) {
                    maxProfit += prices[i] - buy;
                    buy = Integer.MAX_VALUE;
                }
            }else if (prices[i] < buy){
                buy = prices[i];
            }
            i++;
        }
        if ( buy != Integer.MAX_VALUE && prices[prices.length-1] > buy) {
            maxProfit += prices[prices.length-1] - buy;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] prices = new int[scanner.nextInt()];
        for (int i = 0; i < prices.length; i++)
            prices[i] = scanner.nextInt();
        scanner.close();

        int result = new BestTimeToBuyAndSellStocks().maxProfit(prices);
        System.out.print(Integer.toString(result));
    }
}