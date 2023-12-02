//que link.
//lc : 
//ac : https://course.acciojob.com/idle?question=029e7dd4-5198-4d4f-a4ea-0363bc35e731

import java.util.*;

class Solution {

    //creating toString() method.
    public static String toString(int r, int c)
    {
        return Integer.toString(r)+" "+Integer.toString(c);
    }
   

    //dfs function.
    public static void dfs(int row, int col, int grid[][], boolean visited[][], ArrayList<String>al, int bRow, int bCol)
    {
        if(row<0 || row >= grid.length || col < 0 || col >=grid[0].length || visited[row][col] == true || grid[row][col] == 0)
        {
            return;
        }

        //mark as visited.
        visited[row][col] = true;
        //do work for the 
        al.add(toString(row - bRow, col - bCol));

        //calling dfs to all direction.
        dfs(row-1, col, grid, visited, al, bRow, bCol);
        dfs(row, col+1, grid, visited, al, bRow, bCol);
        dfs(row+1, col, grid, visited, al, bRow, bCol);
        dfs(row, col-1, grid, visited, al, bRow, bCol);
        
    }

  
  public static int countDistinctIslands(int[][] grid) {

      //row and col length.
      int row = grid.length;
      int col = grid[0].length;

      //created visited boolean array.
      boolean visited[][] = new boolean[row][col];

      //creating hashset to store the unique arraylist.
      HashSet<ArrayList<String>> hset = new HashSet<>();

      for(int i=0; i<row; i++)
          {
              for(int j=0; j<col; j++)
                  {
                      if(grid[i][j] == 1 && visited[i][j] == false)
                      {
                          ArrayList<String> pair = new ArrayList<>();
                           dfs(i, j, grid, visited, pair, i, j); 
                          hset.add(pair);
                      }
                  }
          }

    
      return hset.size();
  }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Solution ob = new Solution();
        int ans = ob.countDistinctIslands(grid);
        System.out.println(ans);
    }
}