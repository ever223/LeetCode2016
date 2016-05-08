package solutions.greedy;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-07 16:53.
 * @DESCRIPTION:
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i ++) {
            if(minPrice < prices[i]) {
                maxProfit += prices[i] - minPrice;
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
