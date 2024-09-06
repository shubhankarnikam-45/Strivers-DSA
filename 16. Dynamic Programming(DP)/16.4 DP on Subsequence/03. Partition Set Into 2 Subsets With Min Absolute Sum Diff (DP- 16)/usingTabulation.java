//que link 
//https://www.naukri.com/code360/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum._842494?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION

public class usingTabulation {
    public static int minSubsetSumDifference(int []arr, int n) {
        
        //total sum
        int sum = 0;
        for(int i=0; i<n; i++) sum+=arr[i];

        boolean dp[][] = new boolean[n][sum+1];

        for(int i=0; i<n; i++) dp[i][0] = true;
        if(arr[0] <= sum) dp[0][arr[0]] = true;

        for(int i=1; i<n; i++)
        {
            for(int target = 1;target <= sum; target++)
            {
                boolean exclude = dp[i-1][target];
                boolean include = false;
                if(arr[i] <= target) 
                {
                    include = dp[i-1][target-arr[i]];
                }

                dp[i][target] = exclude || include;
            }
        }

        int mini = Integer.MAX_VALUE;

        for(int s1=0; s1<= sum; s1++)
        {
            if(dp[n-1][s1] == true)
            {
                int s2 = sum - s1;
                mini = Math.min(mini, Math.abs(s1 - s2));
            }
        }

        return mini;
    }
}