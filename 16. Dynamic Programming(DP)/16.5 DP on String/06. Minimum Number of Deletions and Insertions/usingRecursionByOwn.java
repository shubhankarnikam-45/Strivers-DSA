//question link.
//https://www.naukri.com/code360/problems/can-you-make_4244510?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=PROBLEM

import java.util.*;
public class usingRecursionByOwn {
    public static int fun(int ind1, int ind2, String s, String t, int dp[][])
    {
        //base case.
        if(ind2 < 0 && ind1 >=0) return ind1 + 1;
        if(ind1 < 0 && ind2 >= 0) return ind2 + 1;
        if(ind1 < 0 || ind2 < 0) return 0;

        //if in dp answer is exists.
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        //if character on both string are equal.
        if(s.charAt(ind1) == t.charAt(ind2))
        {
            return dp[ind1][ind2] = 0 + fun(ind1 - 1, ind2 - 1, s, t, dp);
        }
        else
        {
            return dp[ind1][ind2] = 1 + Math.min(fun(ind1 - 1, ind2, s, t, dp), fun(ind1, ind2 - 1, s, t,dp));
        }


    }
    public static int canYouMake(String s, String t) {
        
        //lengt of two string.
        int m = s.length();
        int n = t.length();

        int dp[][] = new int[m][n];
        for(int arr[] : dp) Arrays.fill(arr, -1);
        
        return fun(m - 1, n - 1, s, t, dp);
    }
}