// Course Schedule - I
//queu link
// https://course.acciojob.com/idle?question=98332447-d28d-42ee-9843-3d4d9d5ea20d

import java.util.*;

class Solution {


    @SuppressWarnings("unchecked")

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean visited[], boolean pathVis[])
    {
        visited[node] = true;
        pathVis[node] = true;

        //going to it's neighbout.
        for(Integer i: adjList.get(node))
            {
                if(visited[i] == false)
                {
                    if(dfs(i, adjList, visited, pathVis) == true)
                        {
                            return true;
                        }
                }
                if(pathVis[i] == true)
                {
                    return true;
                }
            }
        pathVis[node] = false;

        return false;
    }
    
    public int canFinish(int v, int[][] prereq) {

        //first created the adjacency list.
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<v;i++)
            {
                adjList.add(new ArrayList<Integer>());
            }

        int m = prereq.length;
        for(int i=0; i<m; i++)
            {
                adjList.get(prereq[i][0]).add(prereq[i][1]);
            }

        //using dfs we solve this question.

        //created visited array.
        boolean visited[] = new boolean[v];
        //crreated path visited array
        boolean pathVis[] = new boolean[v];

        for(int i=0; i<v; i++)
            {
                if(visited[i] == false)
                {
                    //if we got the cycle then we return true
                    if(dfs(i, adjList, visited, pathVis) == true) 
                    {
                        return 0;
                    }
                }
            }


        return 1;

        
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.canFinish(N,prerequisites));

    }
}