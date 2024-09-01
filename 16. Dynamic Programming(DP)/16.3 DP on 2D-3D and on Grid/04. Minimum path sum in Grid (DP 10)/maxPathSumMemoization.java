class Solution {
    public int fun(int i, int j, int grid[][], int dp[][])
    {
        
        if(i < 0 || j < 0) return 100000;

        if(i == 0 && j == 0) return grid[0][0];

        if(dp[i][j] != -1) return dp[i][j];

        int up = fun(i-1, j, grid, dp);
        int left = fun(i, j-1, grid, dp);

        int candidate = grid[i][j] + Math.min(up, left);

        return dp[i][j] = candidate;
    }
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];
        

        // return fun(m-1, n-1, grid, dp);

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i == 0 && j == 0)
                {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                
                int up = (i-1 >= 0) ? (dp[i-1][j]) : (100000);
                int left = (j-1 >= 0) ? (dp[i][j-1]) : (100000);

                int candidate = grid[i][j] + Math.min(up, left);
                dp[i][j] = candidate;
            }
        }

        

        return dp[m-1][n-1];
    }
}