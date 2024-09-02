class Solution{


    static boolean fun(int idx, int arr[],  int target, int dp[][])
    {
        
        if(target == 0) return true;   
        
        if(idx == 0) return arr[0] == target;
        
        if(dp[idx][target] != -1) return dp[idx][target] == 1;

        boolean no = fun(idx - 1, arr, target, dp);        
        boolean yes = false;
        if(arr[idx] <= target)
        yes = fun(idx - 1 , arr, target - arr[idx],  dp);

        
        int result = (yes || no) ? (1) : (0);
        dp[idx][target] = result;
        return result == 1;
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        
        boolean dp[][] = new boolean[N][sum+1];
        
        // return fun(N-1, arr, sum, dp);
        
        
        //TABULATION
        //1. writing base case.
        for(int i=0; i<N ;i++)
        {
            dp[i][0] = true;
        }
        
        if(arr[0] <= sum)
        dp[0][arr[0]] = true;
        
        //2. lookat state.
        for(int index = 1; index < N; index++)
        {
            for(int target = 1; target <= sum; target++)
            {
                boolean no = dp[index - 1][target];        
                boolean yes = false;
                if(arr[index] <= target)
                yes = dp[index - 1][target - arr[index]];
        
                
                int result = (yes || no) ? (1) : (0);
                dp[index][target] = result == 1;
            }
        }
        
        return dp[N-1][sum];
    }
}