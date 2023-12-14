//que link
// https://course.acciojob.com/idle?question=3edb452e-df81-47af-b62b-1787b0dbdcf1
//https://leetcode.com/problems/path-with-minimum-effort/description/

import java.util.*;

public class Main {

    //created the pair class.
    public static class Pair
        {
            int dist;
            int row;
            int col;

            Pair(int row, int col, int dist)
            {
                this.dist = dist;
                this.col = col;
                this.row = row;
            }
        }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int rows = sc.nextInt(), columns = sc.nextInt();
    int[][] heights = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        heights[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(minimumEffortPath(heights));
  }

  public static int minimumEffortPath(int[][] heights) {

      int row = heights.length;
      int col = heights[0].length;
      
    //created the priority queue.
    //this is min heap.
      PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.dist - y.dist);

      //created the distance 2d array.
      int dist[][]  = new int[row][col];

      //initilize dist array with infinite.
      for(int i=0; i<row; i++)
          {
              for(int j=0; j<col; j++)
                  {
                      dist[i][j] = (int)(1e9);
                  }
          }

      //make source is 0
      dist[0][0] = 0;

      //adding the initial state to the priority queue.
      pq.add(new Pair(0, 0, 0));

      //created the delta row and coloumn going to the 4 direction.
      int dr[] = {-1, 0, 1, 0};
      int dc[] = {0, 1, 0, -1};

      //we do our operation till the queue is empty.
      while(pq.size() > 0)
          {
              //pop
              Pair top = pq.remove();

              //extract row, column and the distance.
              int r = top.row;
              int c = top.col;
              int d = top.dist;

              //this is when we found the destination row and column.
              if(r == row -1 && c == col -1)
              {
                  return d;
              }

              //now we going to the all 4 direction.
              for(int i=0; i<4; i++)
                  {
                        //new row and column.
                      int nrow = r + dr[i];
                      int ncol = c + dc[i];

                      //checking for validity.
                      if(nrow >=0 && ncol >=0 && nrow < row && ncol < col)
                      {
                          //absolute difference.
                          int absDiff = Math.max(Math.abs(heights[r][c] - heights[nrow][ncol]), d);

                          if(dist[nrow][ncol] > absDiff)
                          {
                              dist[nrow][ncol] = absDiff;
                              pq.add(new Pair(nrow, ncol, absDiff));
                          }
                          
                      }

                      
                  }
          }


        //this is when we not found.
      return -1;




      
  }
}