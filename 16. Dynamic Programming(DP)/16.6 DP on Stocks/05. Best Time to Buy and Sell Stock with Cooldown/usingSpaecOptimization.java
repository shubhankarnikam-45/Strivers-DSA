//question link.
//https://www.naukri.com/code360/problems/highway-billboards_3125969?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=SUBMISSION


import java.util.*;
public class usingSpaecOptimization {
    
    public static int stockProfit(int[] prices) {
        
        int n = prices.length;

        //creating dp.
        int ahead[][] = new int [2][2];
        int cur[][] = new int [2][2];

        
        //TABULATION.
        //here no need to write the base in tabulation.

        for(int ind = n - 1; ind>=0; ind--)
        {
            for(int buy = 0; buy<=1; buy++)
            {
                for(int limit = 1; limit>=0; limit--)
                {
                    int profit = 0;

                    if(limit == 1)
                    {
                        profit = ahead[1][0];
                    }
                    else if(buy == 1) //buy
                    {
                        profit = Math.max(-prices[ind] + ahead[0][0], 0 + ahead[1][0]);
                    }
                    else //sell.
                    {
                        profit = Math.max(prices[ind] + ahead[1][1], 0 + ahead[0][0]);
                    }

                    cur[buy][limit] = profit;
                }

                ahead = cur.clone();
            }
        }

        return ahead[1][0];
    }
}

