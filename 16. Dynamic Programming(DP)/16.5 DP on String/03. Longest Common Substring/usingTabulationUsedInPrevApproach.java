//question link.
//https://www.geeksforgeeks.org/problems/longest-common-substring1452/1


class usingTabulationUsedInPrevApproach {
    public int longestCommonSubstr(String s, String t) {
         int m = s.length();
        int n = t.length();
        
        int dp[][] =  new int[m + 1][n + 1];
        
        int maxi = Integer.MIN_VALUE;
        
        
        for(int ind1 = 1; ind1 <= m; ind1++)
        {
            for(int ind2 = 1; ind2 <= n; ind2++)
            {
                if(s.charAt(ind1 - 1) == t.charAt(ind2 - 1))
                {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                }
                else
                {
                    dp[ind1][ind2] = 0;
                }
                
                maxi  = Math.max(maxi, dp[ind1][ind2]);
            }
            
           
        }
        
        return maxi;
    }
}