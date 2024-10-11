//question link.
//Leetcode : https://leetcode.com/problems/distinct-subsequences/
//coding ninja : https://www.naukri.com/code360/problems/subsequence-counting_3755256?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=SUBMISSION


import java.util.*;
public class usingTabulation {
    static int prime = (int) (Math.pow(10, 9) + 7);
    public static int distinctSubsequences(String s, String t) {
        
        //length of two string.
        int m = s.length();
        int n = t.length();

        int dp[][] = new int[m + 1][n + 1];

        //base cases.
        for(int ind1 = 0; ind1<=n; ind1++) dp[0][ind1] = 0;
        for(int ind2 = 0; ind2 <= m; ind2++) dp[ind2][0] = 1;
        
        //traverl and solve.
        for(int ind1 = 1; ind1 <=m; ind1++)
        {
            for(int ind2 = 1; ind2<=n; ind2++)
            {
                //if character matches.
                if(s.charAt(ind1 - 1) == t.charAt(ind2 - 1))
                {
                    dp[ind1][ind2] = (dp[ind1 - 1][ind2 - 1] + dp[ind1 - 1][ind2]) % prime;
                }
                else
                {
                    dp[ind1][ind2] =  (dp[ind1 - 1][ind2] ) % prime;
                }
            }
        }

        return dp[m][n];
    }
}