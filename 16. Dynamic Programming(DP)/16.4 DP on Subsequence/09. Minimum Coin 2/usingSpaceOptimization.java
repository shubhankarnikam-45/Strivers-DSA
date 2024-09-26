import java.util.*;
public class usingSpaceOptimization {

	
	public static long countWaysToMakeChange(int denominations[], int value){
        
		//length of denomination.
		int n = denominations.length;

		long dp[][] = new long[n][value+1];

		long prev[] = new long[value + 1];
		long cur[] = new long[value + 1];

		//Tabulation.

		//base case.
		for(int  target = 0; target <= value; target++)
		{
			if(target % denominations[0] == 0) prev[target] = 1;
			else prev[target] = 0;
			
		}

		for(int index=1; index < n; index++)
		{
			for(int target = 0; target<= value; target++)
			{
				long notPick = prev[target];
		
				long pick = 0;
				if(denominations[index] <= target)
				{
					pick = cur[target - denominations[index]];
				}

				cur[target] = notPick + pick;
			}

			prev = cur;
		}

		return prev[value];

	}
	
}