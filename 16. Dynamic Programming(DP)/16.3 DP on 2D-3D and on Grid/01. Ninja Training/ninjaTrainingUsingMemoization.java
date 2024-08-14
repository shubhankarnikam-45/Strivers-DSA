public class ninjaTrainingUsingMemoization {

    public static int findAns(int day, int last, int points[][], int dp[][])
    {

        if(dp[day][last] != -1)
        {
            return dp[day][last];
        }
        
        //base case
        if(day == 0)
        {
            int maxi = 0;
            for(int i=0; i<3;i++)
            {
                if(i != last)
                    maxi = Math.max(maxi, points[day][i]);
            }

            return dp[day][last] = maxi;
        }

        


        int maxi = 0;
        for(int i=0; i<3 ;i++)
        {
            if(i != last)
            {
                int point = points[day][i] + findAns(day - 1, i, points, dp);
                maxi = Math.max(maxi, point);
            }
           
        }

        return dp[day][last] =  maxi;
    }
    public static int ninjaTraining(int n, int points[][]) {

        //creating the dp of size n * 4
        int dp[][] = new int[n][4];
        
        for(int i=0 ;i<dp.length; i++)
        {
            for(int j=0; j<dp[0].length; j++)
            {
                dp[i][j] = -1;
            }
        }

        return findAns(n-1, 3, points, dp);
        
    }

}