//question link.
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/


class usingTabulation {
    
    public int maxProfit(int[] prices) {
        
        //creating dp 2d array to store the duplicate values.
        int n = prices.length;
        int dp[][] = new int[n + 1][2];

        //TABULATION.
        
        //write the base case.
        dp[n][1] = dp[n][0] = 0;

        //travel and solve
        for(int ind = n - 1; ind>=0; ind--)
        {
            for(int buy = 0; buy<=1; buy++)
            {
                if(buy == 1) //buy
                {
                    dp[ind][buy] = Math.max(-prices[ind] + dp[ind + 1][0], 0 + dp[ind + 1][1]);
                }
                else //sell
                {
                    dp[ind][buy] = Math.max(prices[ind] + dp[ind + 1][1], 0 + dp[ind + 1][0]);

                }
            }
        }

      
        return dp[0][1];
    }
}