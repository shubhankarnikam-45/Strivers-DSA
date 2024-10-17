//problem link.
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/submissions/1424996301/

class usingMemoization {
    public int fun(int ind, int buy, int cnt, int prices[], int dp[][][]) {
        // base case.
        if (ind == prices.length)
            return 0;
        if (cnt == 2)
            return 0;

        // if answe already exists.
        if (dp[ind][buy][cnt] != -1)
            return dp[ind][buy][cnt];

        int profit = 0;

        if (buy == 1) // buy
        {
            profit = Math.max(-prices[ind] + fun(ind + 1, 0, cnt, prices, dp), 0 + fun(ind + 1, 1, cnt, prices, dp));
        } else // sell
        {
            profit = Math.max(prices[ind] + fun(ind + 1, 1, cnt + 1, prices, dp), 0 + fun(ind + 1, 0, cnt, prices, dp));
        }

        return dp[ind][buy][cnt] = profit;
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;

        // creating the 3d dp to optimize this.
        int dp[][][] = new int[n][2][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return fun(0, 1, 0, prices, dp);
    }
}