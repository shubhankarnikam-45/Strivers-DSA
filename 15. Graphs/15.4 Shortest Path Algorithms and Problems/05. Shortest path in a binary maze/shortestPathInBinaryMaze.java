
//que link: 
//https://www.geeksforgeeks.org/problems/shortest-source-to-destination-path3544/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

class Solution {
    class Pair
    {
        int row;
        int col;
        int dist;

        Pair(int r, int c, int d)
        {
            row =r;
            col =c;
            dist =d;
        }
    }
    
    int shortestDistance(int N, int M, int grid[][], int x, int y) {
        
         //created the 2d matrix that stores the answer.
        int ans[][] =new int[grid.length][grid[0].length];
        
        if(0 == x && 0 == y)
        {
            return 0;
        }

        //created queue 
        Queue<Pair> queue = new ArrayDeque<>();
        
        if(grid[0][0] != 0)
        {
             queue.add(new Pair(0,0,1));
            ans[0][0] = 1;
        }
       

        //delta row and delta column.
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        
         for(int i = 0;i<N;i++) {
            for(int j =0;j<M;j++) {
                ans[i][j] = (int)(1e9); 
            }
        }

        while(queue.size() > 0)
        {
            //pop;
            Pair top = queue.remove();

            //row.
            int row = top.row;
            int col = top.col;
            int dist = top.dist;
            
            if(row == x && col == y)
            {
                return dist-1;
            }

            //now we can move 4 directionaly.
            
            for(int i=0; i<4; i++)
            {
                //new row and column.
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                
                //check for the corner cases.
                if(nrow >= 0 && ncol >=0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == 1)
                {
                    if(dist + 1 < ans[nrow][ncol])
                    {
                        ans[nrow][ncol] = dist + 1;
                        queue.add(new Pair(nrow, ncol, ans[nrow][ncol]));
                    }
                }
            }
        }
        
        return -1;
        
    }
};