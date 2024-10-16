//question link.
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/


class usingSpaceOptimization {
    
    public int maxProfit(int[] prices) {
        
        //creating dp 2d array to store the duplicate values.
        int n = prices.length;
        
        //SPACE OPTIMIZATION.
        
        //write the base case.
        int ahead[] = new int[2];
        int cur[] = new int[2];



        //travel and solve
        for(int ind = n - 1; ind>=0; ind--)
        {
            for(int buy = 0; buy<=1; buy++)
            {
                if(buy == 1) //buy
                {
                    cur[buy] = Math.max(-prices[ind] + ahead[0], 0 + ahead[1]);
                }
                else //sell
                {
                    cur[buy] = Math.max(prices[ind] + ahead[1], 0 + ahead[0]);

                }
            }

            ahead = cur.clone();
        }

        return ahead[1];
    }
}