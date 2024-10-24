//question link.
//https://www.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
//https://leetcode.com/problems/longest-increasing-subsequence/description/



//this program time complexity is O(n)
class usingTabulationPart2 {
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int arr[]) {
        
        int dp[] = new int[n];
        
        int ans = 1;
        for(int i = 0; i<n; i++)
        {
            dp[i] = 1;
            int max = 1;
            
            for(int j=0; j<= i - 1; j++)
            {
                if(arr[j] < arr[i])
                {   
                    max = Math.max(dp[j] + 1, max);
                }
            }
            
            dp[i] = max;
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
