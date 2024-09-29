//this is follow up question of last question.
//this question i solve using brute force (25 / 50) where i solve the 50% test cases.
//in GFG we have to print the all longest common subsequence (this only possible using brute force)
//when we only print the one subsequence then we use the stiver's tabulation approach.

import java.util.*;
public class usingTabulatin {

	
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

		int i = m ;
		int j = n ;

		//string that holds answer.
		String ans = "";
		while(i > 0 && j > 0)
		{
			if(s.charAt(i - 1) == t.charAt(j - 1))
			{
				ans = s.charAt(i - 1) + ans;
				i = i - 1;
				j = j - 1;
			}
			else if(dp[i-1][j] > dp[i][j-1])
			{
				i = i - 1;
			}
			else
			{
				j = j - 1;
			}
		}

		System.out.println("answer ==> "+ans);
		return dp[m][n];
    }

}