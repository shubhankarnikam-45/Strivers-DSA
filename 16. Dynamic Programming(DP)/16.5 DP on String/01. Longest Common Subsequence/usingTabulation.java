//question link.
//https://www.naukri.com/code360/problems/longest-common-subsequence_624879?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM



import java.util.*;
public class usingTabulation {

	
	public static int lcs(String s, String t) {
		
		//here we use the pattern match / not match.
		int m = s.length();
		int n = t.length();

		//creating dp array.
		int dp[][] = new int[m + 1] [n + 1];
		
		//TABULATION.

		//first we write the base case.
		for(int index2 = 0; index2 <=n; index2++) dp[0][index2] = 0;
		for(int index1 = 0; index1 <=m; index1++) dp[index1][0] = 0;

		for(int index1 = 1; index1 <= m; index1++)
		{
			for(int index2 = 1; index2 <= n; index2++)
			{
				//if string at current index matches.
				if(s.charAt(index1 - 1) == t.charAt(index2 - 1))
				{
					dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
				}
				else 
				{
					dp[index1][index2] = 0 + Math.max(dp[index1 - 1][index2], dp[index1][ index2 - 1]);
				}
				
			}
		}

		return dp[m][n];
    }

}