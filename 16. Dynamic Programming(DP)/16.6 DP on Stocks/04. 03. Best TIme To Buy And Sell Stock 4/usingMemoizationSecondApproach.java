//question link.
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

class usingMemoizationSecondApproach {
    public int fun(int ind, int transNo, int k, int prices[])
    {
        //base case.
        if(ind == prices.length || transNo == k * 2) return 0;

        int profit = 0;

        if(transNo % 2 == 0) //even ==> Buy
        {
            profit = Math.max(-prices[ind] + fun(ind + 1, transNo + 1, k,  prices), 0 + fun(ind + 1, transNo, k, prices));
        }
        else //odd ==> Sell
        {
            profit = Math.max(prices[ind] + fun(ind + 1, transNo + 1, k , prices), 0 + fun(ind + 1, transNo, k, prices));
        }

        return profit;
    }
    public int maxProfit(int k, int[] prices) {
        
        return fun(0, 0, k, prices);
    }
}