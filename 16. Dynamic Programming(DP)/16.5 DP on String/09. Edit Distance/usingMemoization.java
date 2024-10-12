//question link.
//https://leetcode.com/problems/edit-distance/

class usingMemoization {

    public  int fun(int ind1, int ind2, String s, String t, int dp[][])
    {
        //base case.
        if(ind2 < 0) return ind1 + 1;
        if(ind1 < 0 ) return ind2 + 1;
        
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        //if character mathc.
        if(s.charAt(ind1) == t.charAt(ind2))
        {
            return dp[ind1][ind2] = 0 + fun(ind1 - 1, ind2 - 1, s, t, dp);
        }
        else
        {
return dp[ind1][ind2] = 1 + Math.min(fun(ind1 , ind2 - 1, s, t , dp), Math.min(fun(ind1 - 1,ind2 - 1, s, t, dp), fun(ind1 - 1 , ind2, s, t, dp)));
        }
    }

    public int minDistance(String s, String t) {
        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n][m];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        // if(n == 0) return m;

        return fun(n - 1, m - 1, s, t,dp);
    }
}