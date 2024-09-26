
import java.util.*;

public class usingTabulation {
    public static int fun(int index, int w, int profit[], int weight[], int dp[][])
    {
        //base case
       
        
        if(index == 0)
        {
            if(weight[index] <= w)
            {
                int temp = w / weight[index];
                return temp * profit[index];
            }
            else return 0;
        }

        if(dp[index][w] != -1) return dp[index][w];

        int notPick =  fun(index - 1, w, profit, weight, dp);

        int pick = 0;
        if(weight[index] <= w)
        {
            pick = profit[index] + fun(index, w - weight[index], profit, weight, dp);
        }

        return dp[index][w] = Math.max(notPick, pick);
    }



    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        
        int dp[][] = new int[n][w + 1];

        
        

        for(int target = 0; target <= w; target++)
        {
            if(weight[0] <= target)
            {
                int temp = (int)target / weight[0];
                dp[0][target] =  temp * profit[0];
            }
            
        }

        for(int index = 1; index <n; index++)
        {
            for(int target = 0; target <= w; target++)
            {
                int notPick =  dp[index - 1][target];

                int pick = Integer.MIN_VALUE;
                if(weight[index] <= target)
                {
                    pick = profit[index] + dp[index][target - weight[index]];
                }

                dp[index][target] = Math.max(notPick, pick);
            }
        }

        return dp[n-1][w];
        
    }
}
