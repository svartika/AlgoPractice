package DynamicProgramming;

public class BestTimeToBuySellShares {
    public int maxProfit(int[] prices) {
       int minPrice=prices[0], maxProfit=0;
       for(int i=0; i<prices.length; i++) {
           minPrice = Math.min(prices[i], minPrice);
           maxProfit = Math.max(prices[i] - minPrice, maxProfit);
       }
       return maxProfit;
    }

    public static void main(String args[]) {
        //int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        int[] prices = new int[] {7,6,4,3,1};
        System.out.println(new BestTimeToBuySellShares().maxProfit(prices));
    }
}
