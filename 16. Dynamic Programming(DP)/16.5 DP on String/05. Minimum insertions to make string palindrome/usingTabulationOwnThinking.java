//question link.
//https://www.naukri.com/code360/problems/minimum-insertions-to-make-a-string-palindrome_985293?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION
//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/submissions/1408080988/

import java.util.*;
public class usingTabulationOwnThinking {
    
    public static int minInsertion(String s) {

        int m = s.length();
        int dp[][] = new int[m][m];
        
        for(int left = m - 1; left>=0; left--)
        {
            for(int right = 0; right <m; right++)
            {
                if(left == right || left > right) continue;

                if(s.charAt(left) == s.charAt(right))   dp[left][right] = 0 + dp[left + 1] [right - 1];
                else  dp[left][right] = Math.min(1 + dp[left + 1][right], 1 + dp[left][right - 1]);
            }
        } 

        return dp[0][m-1];

    }
}