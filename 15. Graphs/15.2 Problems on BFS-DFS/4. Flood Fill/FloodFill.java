//que
//https://leetcode.com/problems/flood-fill/description/


class Solution {

    int dr[] = {-1, 0, 1, 0};
    int dc[] = {0, 1, 0, -1};

    public void floodFillHelper(int [][]image, int sr, int sc, int color, boolean[][] visited,int com)
    {

        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visited[sr][sc] == true || image[sr][sc] != com)
        {
            return;
        }

        visited[sr][sc] = true;
        image[sr][sc] = color;
        
        for(int j=0; j<4; j++)
        {
            int drow = sr + dr[j];
            int dcol = sc + dc[j];

            floodFillHelper(image, drow, dcol, color, visited, com);
        }

        

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        //row
        int row = image.length;
        int col = image[0].length;

        //created visited array
        boolean visited[][]  = new boolean[row][col];
        int com = image[sr][sc];

        floodFillHelper(image, sr, sc, color, visited, com);

        return image;

    }
}