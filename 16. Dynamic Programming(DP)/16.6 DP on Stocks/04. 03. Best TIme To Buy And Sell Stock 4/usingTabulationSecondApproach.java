//question link.
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/


class usingTabulationSecondApproach {
    public int fun(int ind, int transNo, int k, int prices[], int dp[][])
    {
        //base case.
        if(ind == prices.length || transNo == k * 2) return 0;


        //if answer already exists
        if(dp[ind][transNo] != -1) return dp[ind][transNo];

        int profit = 0;

        if(transNo % 2 == 0) //even ==> Buy
        {
            profit = Math.max(-prices[ind] + fun(ind + 1, transNo + 1, k,  prices, dp), 0 + fun(ind + 1, transNo, k, prices, dp));
        }
        else //odd ==> Sell
        {
            profit = Math.max(prices[ind] + fun(ind + 1, transNo + 1, k , prices, dp), 0 + fun(ind + 1, transNo, k, prices, dp));
        }

        return dp[ind][transNo] = profit;
    }
    public int maxProfit(int k, int[] prices) {
        
        int n = prices.length;
        int dp[][] = new int[n + 1][k * 2 + 1];

        //TABULATION.

        for(int ind = n - 1;ind>=0; ind--)
        {
            for(int transNo = k * 2 -1 ; transNo >=0; transNo--)
            {
                int profit = 0;

                        if(transNo % 2 == 0) //even ==> Buy
                        {
                            profit = Math.max(-prices[ind] + dp[ind + 1][transNo + 1] , 0 + dp[ind + 1][transNo]);
                        }
                        else //odd ==> Sell
                        {
                            profit = Math.max(prices[ind] + dp[ind + 1][transNo + 1], 0 + dp[ind + 1][ transNo]);
                        }

                        dp[ind][transNo] = profit;
            }
        }
        return dp[0][0];
    }
}