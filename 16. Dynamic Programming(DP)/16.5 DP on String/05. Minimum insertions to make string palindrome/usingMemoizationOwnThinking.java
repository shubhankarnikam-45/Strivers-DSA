//question link.
//https://www.naukri.com/code360/problems/minimum-insertions-to-make-a-string-palindrome_985293?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION
//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/submissions/1408080988/

import java.util.*;
public class usingMemoizationOwnThinking {
    public static int fun(int left, int right, String s, int dp[][])
    {
        //base case.
        if(left == right) return 0;
        if(left > right) return 0;

        if(dp[left][right] != -1) return dp[left][right];

        //if both characters are matches.
        if(s.charAt(left) == s.charAt(right))   return dp[left][right] = 0 + fun(left + 1, right - 1, s, dp);
        
        return dp[left][right] = Math.min(1 + fun(left + 1, right, s, dp), 1 + fun(left, right - 1, s, dp));

    }
    public static int minInsertion(String str) {

        int m = str.length();
        int dp[][] = new int[m][m];

        for(int arr[] : dp) Arrays.fill(arr, -1);

        return fun(0, m - 1, str, dp); 

    }
}