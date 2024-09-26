import java.util.*;
public class usingTabulation {

	
	public static long countWaysToMakeChange(int denominations[], int value){
        
		//length of denomination.
		int n = denominations.length;

		long dp[][] = new long[n][value+1];

		//Tabulation.

		//base case.
		for(int target = 0; target <= value; target++)
		{
			if(target % denominations[0] == 0) dp[0][target] = 1;
			else dp[0][target] = 0;
			
		}

		for(int index=1; index < n; index++)
		{
			for(int target = 0; target<= value; target++)
			{
				long notPick = dp[index - 1][target];
		
				long pick = 0;
				if(denominations[index] <= target)
				{
					pick = dp[index][target - denominations[index]];
				}

				dp[index][target] = notPick + pick;
			}
		}

		return dp[n-1][value];

	}
	
}