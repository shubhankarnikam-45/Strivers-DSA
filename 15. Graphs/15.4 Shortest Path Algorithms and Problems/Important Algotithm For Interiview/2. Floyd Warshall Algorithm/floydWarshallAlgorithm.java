
// que link
//https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1


class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        //lengt of row and column.
        int row = matrix.length;
        int col = matrix[0].length;
    
        //as when maxtrix[i][j] == -1 their is no edge from i to j.
        //hence we put the 'infinite' for this case.
        // 'infinite' ==> 10000 (see contraint)
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(matrix[i][j] == -1)
                {
                    matrix[i][j] = 10000;
                }
            }
        }
        
        
        for(int via=0; via<row; via++)
        {
            for(int i=0; i<row; i++)
            {
                for(int j=0; j<col; j++)
                {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }
        
        
        //as we put the -1 to 10000
        //now it's time to revert it.
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(matrix[i][j] == 10000)
                {
                    matrix[i][j] = -1;
                }
            }
        }
        
        
        
    }
}