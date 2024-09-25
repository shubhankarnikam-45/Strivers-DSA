import java.util.* ;
import java.io.*; 
public class usingTabulation {

    
    public static int minimumElements(int arr[], int x) {
        
        //length of array,
        int n = arr.length;

        int dp[][] = new int[n][x + 1];
        



        for(int i=0; i<=x; i++)
        {
            if(i % arr[0] == 0) dp[0][i] = i/ arr[0];
            else dp[0][i] = 10000009;
        }

        for(int idx = 1; idx<n; idx++)
        {
            for(int target = 0; target <=x; target++)
            {
                    int notTake = 0 + dp[idx -1][target];

                    int take = 0;
                    if(arr[idx] <= target)
                        take = 1 + dp[idx][target - arr[idx]]; 
                    else 
                        take = 0 + dp[idx -1][target];
                
                    dp[idx][target] = Math.min(take, notTake);
            }
        }
        if(dp[n-1][x] == 10000009) return -1;
        else return dp[n-1][x];
    }

}