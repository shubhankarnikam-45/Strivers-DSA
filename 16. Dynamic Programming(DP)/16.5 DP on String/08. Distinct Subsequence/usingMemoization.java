//question link.
//Leetcode : https://leetcode.com/problems/distinct-subsequences/
//coding ninja : https://www.naukri.com/code360/problems/subsequence-counting_3755256?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=SUBMISSION

class usingMemoization {

    public  int fun(int ind1, int ind2, String s, String t, int dp[][])
    {
        //base case.
        if(ind2 < 0) return 1;
        if(ind1 < 0) return 0;
        
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        //if character matches.
        if(s.charAt(ind1) == t.charAt(ind2))
        {
            return dp[ind1][ind2] = fun(ind1 - 1, ind2 - 1, s, t, dp) + fun(ind1 - 1, ind2, s, t, dp);
        }
        else
        {
            return  dp[ind1][ind2] =  fun(ind1 - 1, ind2, s, t, dp);
        }
    }
    public int numDistinct(String s, String t) {
         //length of two string.
        int m = s.length();
        int n = t.length();

        int dp[][] = new int[m][n];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return fun(m - 1, n - 1, s, t, dp);
    }
}