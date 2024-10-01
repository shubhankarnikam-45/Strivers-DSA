class usingTabulation
 {
   
    public int longestPalindromeSubseq(String s) {
        
        int m = s.length();
        int dp[][] = new int[m][m];
       

        for(int left = (m - 1); left >= 0; left--)
        {
            for(int right = 0; right <m; right++)
            {

                if(left == right) dp[left][right] = 1;
                else if(left > right) dp[left][right] = 0;
                else
                {
                        if(s.charAt(left) == s.charAt(right))
                        {
                                dp[left][right] = 2 + dp[left + 1] [right - 1];
                        }
                        else
                        dp[left][right] = Math.max(dp[left + 1] [right] , dp[left][right - 1] );
                }

            }
        }

        return dp[0][m - 1];
    }
}