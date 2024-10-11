//question link.
//https://www.naukri.com/code360/problems/shortest-supersequence_4244493?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=SUBMISSION


import java.util.* ;
import java.io.*; 
public class usingStiverAppraoch {
    public static String shortestSupersequence(String s, String t) {
        
        //we use the LCS to solve this question.

        //length of two strings.
        int m = s.length();
        int n = t.length();

        //created dp array.
        int dp[][] = new int[m + 1][n + 1];

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
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }

        int i = m;
        int j = n;

        String ans = "";
        while(i > 0 && j > 0)
        {
            //if character matches.
            if(s.charAt(i - 1) == t.charAt(j - 1))
            {
                ans = ans + s.charAt(i - 1);
                i--;
                j--;
            }
            else if(dp[i - 1][j] > dp[i][j - 1])
            {
                ans = ans + s.charAt(i - 1);
                i--;
            }
            else
            {
                ans = ans + t.charAt(j - 1);
                j--;
            }
        }

        while(i > 0)
        {
            ans += s.charAt(i - 1);
            i--;
        }  
        while(j > 0) 
        {
            ans += t.charAt(j - 1);
            j--;
        }

          String ans2=new StringBuilder(ans).reverse().toString();

        return ans2;
    }

}