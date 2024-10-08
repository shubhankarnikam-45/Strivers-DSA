

import java.util.*;
public class usingTabulationByOwn {
    
    public static int canYouMake(String s, String t) {
        
        //lengt of two string.
        int m = s.length();
        int n = t.length();

        int dp[][] = new int[m + 1][n + 1];
        
        //TABULATION.
        //first we write the base case.
        for(int ind2 = 1; ind2 <= n; ind2++) dp[0][ind2] = ind2;
        for(int ind1 = 1; ind1 <= m; ind1++) dp[ind1][0] = ind1;
        
        for(int ind1 = 1; ind1 <= m; ind1++)
        {
            for(int ind2 = 1; ind2 <= n; ind2++)
            {
                 //if character on both string are equal.
                if(s.charAt(ind1 - 1) == t.charAt(ind2 - 1))
                {
                    dp[ind1][ind2] = 0 + dp[ind1 - 1][ind2 - 1];
                }
                else
                {
                    dp[ind1][ind2] = 1 + Math.min(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }

            }
        }
        
        return dp[m][n];
    }
}