
class Solution{


    static boolean fun(int idx, int arr[], int sum, int target, int dp[][])
    {
        
        if(sum == target) return true;   
        
        if(idx == arr.length || sum > target) return false;
        
        if(dp[idx][sum] != -1) return dp[idx][sum] == 1;
        
        boolean yes = fun(idx + 1, arr, sum + arr[idx], target, dp);
        boolean no = fun(idx + 1, arr, sum, target, dp);
        
        int result = (yes || no) ? (1) : (0);
        dp[idx][sum] = result;
        return result == 1;
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        
        int dp[][] = new int[N][sum+1];
        
        for(int brr[] : dp)
        {
            Arrays.fill(brr, -1);
        }
        
        return fun(0, arr, 0, sum, dp);


        
    }
}