//question link.
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class usingMemoization {
    public int fun(int ind, int buy, int prices[], int dp[][])
    {
        //base case.
        if(ind == prices.length) return 0;

        //if in dp already exists.
        if(dp[ind][buy] != -1) return dp[ind][buy];

        if(buy == 1) //buy
        {
            return dp[ind][buy] = Math.max(-prices[ind] + fun(ind + 1, 0, prices, dp), 0 + fun(ind + 1, 1, prices, dp));
        }
        else //sell
        {
            return dp[ind][buy] =  Math.max(prices[ind] + fun(ind + 1, 1, prices, dp), 0 + fun(ind + 1, 0, prices, dp));
        }
    }
    public int maxProfit(int[] prices) {
        
        //creating dp 2d array to store the duplicate values.
        int dp[][] = new int[prices.length][2];

        for(int arr[] : dp) Arrays.fill(arr, -1);
        return fun(0 , 1, prices, dp);
    }
}