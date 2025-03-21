
//question link.
//https://www.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
//https://leetcode.com/problems/longest-increasing-subsequence/description/


//the expected time compleixity of given program is O(n) and
//this program time complexity is O(n * n);
class usingSpaceOptimization {
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
    static int longestSubsequence(int n, int arr[]) {
        
        //TABHLATION.
        //we using 2d dp to optimize this.
        int ahead[] = new int[n+1];
        int cur[] = new int[n+1];
        
        
        for(int ind = n-1; ind >= 0; ind--)
        {
            for(int prevInd = ind-1; prevInd >= -1; prevInd--)
            {
                //this variable used for not take condition.
                int notTake = ahead[prevInd + 1];
                
                //now we use variable for take condition.
                int take = 0;
                
                if(prevInd == -1 || arr[ind] > arr[prevInd])
                {
                    take = 1 + ahead[ind+1];    
                }
                
                cur[prevInd + 1] = Math.max(take, notTake);
            }
            
            ahead = cur.clone();
        }
        
        return ahead[-1 + 1];
    }
}
