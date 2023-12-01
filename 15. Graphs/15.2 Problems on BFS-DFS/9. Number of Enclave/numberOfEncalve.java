//que link
//// https://leetcode.com/problems/number-of-enclaves/submissions/1110238483/


class Solution {

     public  void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt(), n = sc.nextInt();
    int[][] grid = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(numEnclaves(grid));
  }

    //dfs function.
    public static void dfs(int row, int col, int grid[][], boolean visited[][])
    {

        if(row < 0 || col < 0 || row >=grid.length || col >=grid[0].length || visited[row][col] == true || grid[row]
          [col] == 0)
        {
            return;
        }

        visited[row][col] = true;
        grid[row][col] = 0;


        dfs(row-1, col, grid, visited);
        dfs(row, col+1, grid, visited);
        dfs(row+1, col, grid, visited);
        dfs(row, col-1, grid, visited);
        
    }

    public int numEnclaves(int[][] grid) {
        //row
      int row = grid.length;
      //column
      int col = grid[0].length;
      
      //created visited boolean 2d array.
      boolean visited[][] = new boolean[row][col];

       for(int i=0; i<row; i++)
           {
               for(int j=0; j<col; j++)
                   {
                       if(i==0 || j==0 || i==row-1 || j==col-1)
                       {
                           if(grid[i][j] == 1) //if their is island.
                           {
                               dfs(i, j, grid, visited);
                           }
                       }
                   }
           }


      //created count to store the final answr.
      int count =0;
      for(int i=0; i<row; i++)
          {
              for(int j=0; j<col; j++)
                  {
                      if( i!=0 && j!=0 && i!=row-1 && j!=col-1 && grid[i][j] == 1)
                      {
                          count++;
                      }
                  }
          }



        return count;
    }
}