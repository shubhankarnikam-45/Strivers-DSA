//question link
//https://leetcode.com/problems/longest-palindromic-subsequence/

class usingRecursion {
    public int fun(int left, int right, String s, int dp[][])
    {
        //base case.
        if(left == right) return 1;
        if(left > right) return 0;

        if(dp[left][right] != -1) return dp[left][right];

        if(s.charAt(left) == s.charAt(right))
        {
            return dp[left][right] = 2 + fun(left + 1, right - 1, s, dp);
        }
        
        return dp[left][right] = Math.max(fun(left + 1, right, s, dp), fun(left, right - 1, s, dp));


    }
    public int longestPalindromeSubseq(String s) {
        
        int m = s.length();
        int dp[][] = new int[m][m];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return fun(0, m - 1, s, dp); 
    }
}