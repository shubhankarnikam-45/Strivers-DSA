//que link : https://www.naukri.com/code360/problems/ninja-s-training_3621003?leftPanelTabValue=SUBMISSION
//time complexity : O(N * 4) * 3
//space complexity : O(N * 4)



import java.util.*;
public class ninjaTrainingUsingTabulation {
    public static int fun(int n, int points[][], int notTake, int dp[][])
    {
        //base case.
        if(n == 0)
        {
            int maxi = Integer.MIN_VALUE;
            for(int i=0; i<=2 ;i++)
            {
                if(i != notTake)
                {
                    maxi = Math.max(points[0][i], maxi);
                }
            }

            return maxi;
        }

        if(dp[n][notTake] != -1) return dp[n][notTake];

        int maxi = Integer.MIN_VALUE;

        for(int i=0 ;i<=2 ;i++)
        {
            if(i != notTake)
            {
              maxi = Math.max(fun(n-1, points, i, dp) + points[n][i], maxi);
            }
        }

        return dp[n][notTake] = maxi;
    }
    public static int ninjaTraining(int n, int points[][]) {

        int dp[][] = new int[n][4];

        //base case.
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for(int day=1 ; day<n; day++)
        {
            for(int last=0; last<=3 ;last++)
            {
                for(int task = 0 ;task < 3 ; task++)
                {
                    if(last != task)
                    {
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }

        return dp[n-1][3];
    }

}