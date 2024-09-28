//question link.
//https://www.naukri.com/code360/problems/longest-common-subsequence_624879?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM


import java.util.*;
public class usingMemoization {

	public static int fun(int index1, int index2, String s, String t, int dp[][])
	{
		//base case.
		if(index1 == 0 || index2 == 0) return 0;

		//if answer already exist.
		if(dp[index1][index2] != -1) return dp[index1][index2];

		//if string at current index matches.
		if(s.charAt(index1 - 1) == t.charAt(index2 - 1))
		{
			return dp[index1][index2] = 1 + fun(index1 - 1, index2 - 1, s, t, dp);
		}

		return dp[index1][index2] = 0 + Math.max(fun(index1 - 1, index2, s, t, dp), fun(index1, index2 - 1, s, t, dp));
	}
	public static int lcs(String s, String t) {
		
		//here we use the pattern match / not match.
		int m = s.length();
		int n = t.length();

		//creating dp array.
		int dp[][] = new int[m + 1] [n + 1];
		for(int arr[] : dp) Arrays.fill(arr, -1);

		return fun(m, n, s, t, dp);
    }

}