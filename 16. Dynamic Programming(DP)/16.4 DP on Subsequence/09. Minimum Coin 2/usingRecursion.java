import java.util.*;
public class usingRecursion {

	public static long fun(int index, int value, int deno[], long dp[][])
	{

		
		//base case.
		if(value == 0) return 1;

		if(index == 0)
		{
			if(value % deno[index] == 0) return 1;
			else return 0;
		}

		// if(dp[index][value] != -1) return 0;

		long notPick = fun(index - 1, value, deno, dp);
		
		long pick = 0;
		if(deno[index] <= value)
		{
			pick = fun(index, value - deno[index], deno, dp);
		}

		return  notPick + pick;
	}
	public static long countWaysToMakeChange(int denominations[], int value){
        
		//length of denomination.
		int n = denominations.length;

		long dp[][] = new long[n][value+1];
		for(long arr[] : dp)   Arrays.fill(arr, -1); 

		return fun(n-1, value, denominations, dp) ;

	}
	
}