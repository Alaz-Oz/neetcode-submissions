class Solution {
    public int maxProfit(int[] prices) {
        /*
            Moving with two pointer buyPoint, sellPoint.
            Starting with 0

            If sellValue <= buyValue:
                use that as buyPoint
            else
                log the buy value (sellVal - buyVal)

        */
        int n = prices.length;
        int maxProfit = 0;
        int buyPoint = 0, sellPoint = 0;
        for(;sellPoint < n; sellPoint++){
            if (prices[sellPoint] <= prices[buyPoint]){
                buyPoint = sellPoint;
            }else {
                int profit = prices[sellPoint] - prices[buyPoint];
                if (profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }
}
