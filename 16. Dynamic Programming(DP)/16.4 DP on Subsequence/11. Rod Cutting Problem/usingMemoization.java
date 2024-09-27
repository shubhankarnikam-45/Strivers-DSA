//que link
//https://www.naukri.com/code360/problems/rod-cutting-problem_800284?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=SUBMISSION


import java.util.*;
public class usingMemoization {
	public static int fun(int index, int rod, int prices[], int dp[][])
	{
		//base case.
		if(index == 0)
		{
			if(index + 1 <= rod)
			{
				int temp = rod / (index + 1);
				return temp * prices[index];
			}
			return 0;
		}

		if(dp[index][rod] != -1) return dp[index][rod];

		int notTake = fun(index - 1, rod, prices, dp);

		int take = 0;
		if(index + 1<= rod)
		{
			take = prices[index] + fun(index, rod - (index + 1), prices, dp);
		}

		return dp[index][rod] = Math.max(notTake, take);
	}
	public static int cutRod(int price[], int n) {
		
		int dp[][] = new int[price.length][n+1];
		for(int arr[] : dp) Arrays.fill(arr, -1);
		return fun(price.length-1, n, price, dp);
	}
}