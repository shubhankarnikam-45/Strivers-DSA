//question link.
//https://www.naukri.com/code360/problems/highway-billboards_3125969?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=PROBLEM


import java.util.*;
public class usingMemoization {
    public static int fun(int ind, int buy, int limit, int prices[], int dp[][][])
    {
        //base case.
        if(ind == prices.length) return 0;


        //if answer already exists.
        if(dp[ind][buy][limit] != -1) return dp[ind][buy][limit];

        int profit = 0;

        if(limit == 1) //we do our task after 1 day
        {
            return fun(ind + 1, 1, 0, prices, dp);
        }
        else if(buy == 1)
        {
            profit = Math.max(-prices[ind] + fun(ind + 1, 0, limit ,prices, dp), 
            fun(ind + 1, 1, limit, prices, dp));
        }
        else //sell
        {
            profit = Math.max(prices[ind] + fun(ind + 1, 1, 1 , prices, dp), 0 + fun(ind + 1, 0, limit, prices, dp));
        }

        return dp[ind][buy][limit] = profit;


    }
    public static int stockProfit(int[] prices) {
        
        int n = prices.length;

        //creating dp.
        int dp[][][] = new int[n][2][2];

        for(int i=0; i<n ;i++)
        {
            for(int j=0; j<2; j++)
            {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return fun(0, 1, 0, prices, dp);
    }
}
