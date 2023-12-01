//queue link
//https://leetcode.com/problems/01-matrix/

class Solution {

    //created pair class.
    class Pair
    {
        int row;
        int col;
        int dist;

        Pair(int row, int col, int dist)
        {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        
        int row = mat.length;
        int col = mat[0].length;

        //this is question of BFS.
        //created dist 2d matrix.
        int dist[][]  = new int[row][col];
        boolean visited[][] = new boolean[row][col];

        //created quue.
        Queue<Pair> queue = new ArrayDeque<>();

        //running loop and find the starging point.
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(mat[i][j]  == 0)
                {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        //created delta row and column.
        int deltaRow[] = {-1, 0, 1, 0};
        int deltaCol[] = {0, 1, 0, -1};

        //actual algorithm start.
        while(queue.size() > 0)
        {
            //remove mark* work add*
            Pair remove = queue.remove();

            //extract the removed value.
            int r = remove.row;
            int c = remove.col;
            int d = remove.dist;
            
            //adding value to the dist 2d array.
            dist[r][c] = d;

            //now we run loop on four side of remove one.
            for(int i=0; i<4; i++)
            {
                //req. row and col.
                int rr = r + deltaRow[i];
                int rc = c + deltaCol[i];

                if(rr >= 0 && rc >=0 && rr < row && rc < col && visited[rr][rc] == false)
                {
                    queue.add(new Pair(rr, rc, d+1));
                    visited[rr][rc] = true;
                }
            }


        }


        //return the dist 2d array.
        return dist;


    }
}
