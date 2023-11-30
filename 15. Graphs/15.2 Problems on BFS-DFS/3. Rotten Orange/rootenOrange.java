class Solution {

    //creating pair clas.
    public class Pair
    {
        int row;
        int col;
        
        Pair(int row,int col)
        {
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        
        //some edge cases.
        if(grid.length == 0)
            return 0;

        //creating queue that used for BFS traversal.
        Queue<Pair> queue = new ArrayDeque<>();

        //size of row and col
        int row = grid.length;
        int col = grid[0].length;

        //count the total number of orange.
        int total = 0;

        //traversig the 2d array and find the starting node.
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                //if current row and col contains the 2 
                if(grid[i][j] == 2)
                {
                    queue.add(new Pair(i,j));
                }

                //count of orange.
                if(grid[i][j] != 0)
                {
                    total++;
                }
            }
        }

        //creating one variable that req. in future for compairion.
        int count =0;

        int cntMin =0;

        //creating delta array.
        int deltaRow[] = {-1, 0, 1, 0};
        int deltaCol []= {0, 1, 0, -1};

        //now actual BFS start.
        while(queue.size() > 0)
        {
            //size 
            int size = queue.size();
             count += size;

            //run loop till size.
            for(int i=1; i<=size; i++)
            {
                //remove from queue.
                Pair remove = queue.remove();

                //abstract the requird row and col
                int rrow = remove.row;
                int rcol = remove.col;

                //using the concept of delta row.
                for(int j=0; j<4; j++)
                {
                    int drow = rrow + deltaRow[j];
                    int dcol = rcol + deltaCol[j];

                    //not acceptable cases.
                    if(drow < 0 || dcol < 0 || drow >= row || dcol >= col || grid[drow][dcol] == 0 ||grid[drow][dcol] == 2)
                    {
                        continue;
                    }

                    //mark.
                    grid[drow][dcol]  = 2;

                    //push neigbou to the queue.
                    queue.add(new Pair(drow, dcol));

                   
                }
            }

            if(queue.size() != 0)
            {
                cntMin ++;
            }
        }

        //consition when some freash orange is remaining.
        if(total != count)
        {
            return -1;
        }

        return cntMin;

    }
}