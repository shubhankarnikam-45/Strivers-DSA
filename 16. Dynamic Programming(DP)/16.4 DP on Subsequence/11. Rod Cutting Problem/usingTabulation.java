//que link
//https://www.naukri.com/code360/problems/rod-cutting-problem_800284?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=SUBMISSION


import java.util.*;
public class usingTabulation {
	
	public static int cutRod(int price[], int n) {
		
		int dp[][] = new int[price.length][n+1];
		
		//TABULATION

		//base case
		for(int rod = 1; rod <= n; rod++)
		{
			if(1 <= rod)
			{
				int temp = rod / 1;
				dp[0][rod] = temp * price[0];
			}
		}

		for(int index = 1; index<price.length; index++)
		{
			for(int rod = 0; rod<=n; rod++)
			{
				int notTake = dp[index - 1][ rod];

				int take = 0;
				if(index + 1<= rod)
				{
					take = price[index] + dp[index][rod - (index + 1)];
				}

				dp[index][rod] = Math.max(notTake, take);
			}
		}
		return dp[price.length-1][n];
	}
}