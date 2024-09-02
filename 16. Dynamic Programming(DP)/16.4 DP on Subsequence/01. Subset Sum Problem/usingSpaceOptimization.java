
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
        
        boolean prev[] = new boolean[sum+1];
      
        
        // return fun(N-1, arr, sum, dp);
        
        
        prev[0] = true;
        
        if(arr[0] <= sum)
        prev[arr[0]] = true;
        
        //2. lookat state.
        for(int index = 1; index < N; index++)
        {
            boolean cur[] = new boolean[sum+1];
            cur[0] = true;
            for(int target = 1; target <= sum; target++)
            {
                boolean no = prev[target];        
                boolean yes = false;
                if(arr[index] <= target)
                yes = prev[target - arr[index]];
        
                
                int result = (yes || no) ? (1) : (0);
                cur[target] = result == 1;
            }
            
            prev = cur;
        }
        
        return prev[sum];
    }
}