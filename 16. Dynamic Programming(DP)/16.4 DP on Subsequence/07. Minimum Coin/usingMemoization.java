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