//question link.
//https://leetcode.com/problems/rotate-image/


class Solution {

    //function for swap.
    public void swap(int i, int j, int [][] mat)
    {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }  

    //function for reverse.
    public void reverse(int arr[])
    {
        int left=0;
        int right = arr.length - 1;
        while(left < right)
        {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    } 
    public void rotate(int[][] matrix) {
        
        //size of matrix
        int n = matrix.length;

        for(int i=0; i<n-1; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                swap(i, j, matrix);
            }
        }

        for(int i=0; i<n; i++)
        {
            reverse(matrix[i]);
        }
    }
}