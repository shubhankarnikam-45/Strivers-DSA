//problem link.
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/submissions/1424996301/

class usingMemoization {
    public int fun(int ind, int buy, int cnt, int prices[])
    {
        //base case.
        if(ind == prices.length) return 0;
        if(cnt == 2) return 0;

        int profit = 0;

        if(buy == 1) //buy
        {
            profit = Math.max(-prices[ind] + fun(ind + 1, 0, cnt , prices), 0 + fun(ind + 1, 1, cnt, prices));   
        }
        else //sell
        {
            profit = Math.max(prices[ind] + fun(ind + 1, 1, cnt + 1, prices), 0 + fun(ind + 1, 0, cnt, prices));
        }

        return profit;
    }
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        return fun(0, 1, 0, prices);
    }
}