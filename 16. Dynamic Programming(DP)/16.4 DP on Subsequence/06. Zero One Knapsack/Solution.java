import java.util.* ;
import java.io.*; 

public class Solution{

     static int fun(int idx, int wt[], int val[], int w, int dp[][])
    {
        if(w == 0) return 0;
        
        if(idx == 0)
        {
            if(wt[idx] <= w) return val[idx];
            else return 0;
        }

        if(dp[idx][w] != -1) return dp[idx][w];
        
        int leftCall = fun(idx - 1, wt, val, w, dp);
        int rightCall = 0;
        
        if(wt[idx] <= w)
        {
            rightCall = val[idx] + fun(idx - 1, wt, val, w - wt[idx], dp);
        }
        
        return dp[idx][w] = Math.max(leftCall, rightCall);
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            

            int dp[][] = new int[n][maxWeight + 1];
            for(int arr[] : dp) Arrays.fill(arr, -1);

            return fun(n-1, weight, value, maxWeight, dp);

    }
}