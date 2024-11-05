//question link.
//https://leetcode.com/problems/rotate-image/

class Solution {
    public void rotate(int[][] matrix) {

      //size of matrix.
      int n = matrix.length;

      int ans[][] = new int[n][n];

    //Time compleixity.
    //O(n * n)
      for(int i=0; i<n; i++)
      {
        for(int j=0; j<n; j++)
        {
            ans[j][n-1-i] = matrix[i][j];
        }
      }  

      for(int i=0; i<n; i++)
      {
        for(int j=0; j<n; j++)
        {
            matrix[i][j] =  ans[i][j];
        }
      }
    }
}