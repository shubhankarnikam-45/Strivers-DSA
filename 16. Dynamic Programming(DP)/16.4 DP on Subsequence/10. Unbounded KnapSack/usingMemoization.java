
import java.util.*;

public class usingMemoization {
    public static int fun(int index, int w, int profit[], int weight[], int dp[][])
    {
        //base case
        if(w == 0) return 0;
        
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

        for(int arr[] : dp) Arrays.fill(arr, -1);
        return fun(n-1, w, profit, weight, dp);
    }
}
