//que link
//https://www.naukri.com/code360/problems/rod-cutting-problem_800284?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=SUBMISSION

public class usingRecursion {
	public static int fun(int index, int rod, int prices[])
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

		int notTake = fun(index - 1, rod, prices);

		int take = 0;
		if(index + 1<= rod)
		{
			take = prices[index] + fun(index, rod - (index + 1), prices);
		}

		return Math.max(notTake, take);
	}
	public static int cutRod(int price[], int n) {
		
		
		return fun(price.length-1, n, price);
	}
}