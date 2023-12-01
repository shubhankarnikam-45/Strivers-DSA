//que link
//https://leetcode.com/problems/surrounded-regions/description/

class Solution {
    public void DFS( int row , int col, char[][]board, boolean visited[][])
    {

        //base case.
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] ==  true ||
        board[row][col] == 'X')
        {
            return;
        }
        
        
            visited[row][col] = true;
        
        DFS(row-1,col, board, visited);
        DFS( row,col+1,board,  visited);
        DFS( row+1,col, board, visited);
        DFS( row,col-1,board,  visited);
    }
    public void solve(char[][] board) {

        boolean visited[][] = new boolean[board.length][board[0].length]; 

        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(i == 0 || i == board.length-1 || j == board[0].length-1 || j == 0) //first row
                {
                    if(board[i][j] == 'O')
                    {
                        DFS(i, j, board, visited);
                    }
                }
                
               
            }
        }

        for(int i=0; i< board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(board[i][j] == 'O' && visited[i][j] == false)
                {
                    board[i][j] = 'X';
                }
            }
        }

       
       
    }
}