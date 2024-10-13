//question link.
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Program {
    public int maxProfit(int[] prices) {
        
        int prevMin = prices[0];
        int max = 0;

        for(int i=1; i<prices.length; i++)
        {
            //finding cost.
            int cost = prices[i] - prevMin;
            max = Math.max(max, cost);

            //update min if any
            prevMin = Math.min(prevMin, prices[i]);
        }

        return max;
    }
}