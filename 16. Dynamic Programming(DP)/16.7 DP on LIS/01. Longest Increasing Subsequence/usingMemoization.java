//question link.
//https://www.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
//https://leetcode.com/problems/longest-increasing-subsequence/description/

class usingMemoization {
    static int fun(int ind, int prevInd, int n, int arr[], int dp[][])
    {
        //base case.
        if(ind == n) return 0;
        
        //if answer is already exists.
        if(dp[ind][prevInd + 1] != -1) return dp[ind][prevInd + 1];
        
        int notTake = 0 + fun(ind + 1, prevInd, n, arr, dp);
        
        int take = 0;
        if(prevInd == -1 || arr[ind] > arr[prevInd])
        {
            take = 1 + fun(ind + 1, ind, n, arr, dp);
        }
        
        return dp[ind][prevInd + 1] = Math.max(take, notTake);
        
    }
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int a[]) {
        
        //we using 2d dp to optimize this.
        int dp[][] = new int[n][n+1];
        for(int arr[] : dp) Arrays.fill(arr, -1);
        
        return fun(0, -1, n, a, dp);
    }
}
