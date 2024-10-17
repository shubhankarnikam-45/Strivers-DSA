//question link.
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/


class usingSpaceOptimizationPart1 {
    
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        //creating the 3d dp to optimize this.
        int after[][] = new int[2][3];
        int cur[][] = new int[2][3];

        
      


        for(int ind = n -1; ind >= 0; ind--)
        {
            for(int buy = 0; buy<=1; buy++)
            {
                for(int cap = 1; cap <= 2; cap++)
                {
                    int profit = 0;

                    if(buy == 1) //buy
                    {
                    profit = Math.max(-prices[ind] + after [0][cap] , 0 + after[1][cap]);   
                    }
                    else //sell
                    {
                        profit = Math.max(prices[ind] + after[1][cap - 1], 0 + after[0][cap]);
                    }

                    cur[buy][cap] = profit;

                }

                after = cur.clone();
            }
        }

        

        return after[1][2];
    }
}