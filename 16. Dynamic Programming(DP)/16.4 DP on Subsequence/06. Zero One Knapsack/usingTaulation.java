import java.util.* ;
import java.io.*; 

public class usingTaulation{

     

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            

            int dp[][] = new int[n][maxWeight + 1];


            for(int i=1; i<=maxWeight; i++)
            {
                if(weight[0] <= i) dp[0][i] = value[0];
            }

            for(int idx = 1; idx<n; idx++)
            {
                for(int wt = 1; wt<= maxWeight; wt++)
                {
                    int leftCall = dp[idx - 1][wt];
                    int rightCall = 0;
        
                    if(weight[idx] <= wt)
                    {
                        rightCall = value[idx] + dp[idx - 1][wt - weight[idx]];
                    }

                    dp[idx][wt] = Math.max(leftCall, rightCall);

        
                }

            }

            return dp[n-1][maxWeight];

    }
}