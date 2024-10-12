//question link.
//https://leetcode.com/problems/edit-distance/


class usingTabulation{


    public int minDistance(String s, String t) {
        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n + 1][m + 1];
        
        //first we wriet down the base cases.
        for(int ind1 = 1; ind1 <=n; ind1++) dp[ind1][0] = ind1;
        for(int ind2 = 1; ind2 <=m; ind2++) dp[0][ind2] = ind2;

        //tabulation.
        for(int ind1 = 1; ind1 <=n; ind1++)
        {
            for(int ind2 = 1; ind2<=m; ind2++)
            {
                //if character matches.
                if(s.charAt(ind1 - 1) == t.charAt(ind2 - 1))
                {
                    dp[ind1][ind2] = dp[ind1 - 1][ind2 - 1];
                }
                else
                {
                    dp[ind1][ind2] =  1 + Math.min(dp[ind1][ind2-1], Math.min(dp[ind1 - 1][ind2 - 1], dp[ind1 -1 ][ind2]));
                }
            }
        }

        return dp[n][m];
    }
}