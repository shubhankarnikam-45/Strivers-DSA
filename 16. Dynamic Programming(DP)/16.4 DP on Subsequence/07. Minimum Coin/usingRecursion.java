import java.util.* ;
import java.io.*; 
public class usingRecursion {

    public static int fun(int idx, int target, int arr[], int dp[][])
    {
        //base case 
        if(target == 0) return 0;
        if(idx == 0)
        {
            if(target %  arr[idx]==0 ) return target/ arr[idx];
            else return 10000009;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int notTake = 0 + fun(idx -1, target, arr, dp);

        int take = 0;
        if(arr[idx] <= target)
            take = 1 + fun(idx, target - arr[idx],arr, dp); 
        else 
            take = 0 + fun(idx -1, target, arr, dp);
    
        return dp[idx][target] = Math.min(take, notTake);
    }
    public static int minimumElements(int num[], int x) {
        
        //length of array,
        int n = num.length;

        int dp[][] = new int[n][x + 1];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        int ans = fun(n-1, x, num, dp);
        if(ans == 10000009) return -1;
        else return ans;
    }

}