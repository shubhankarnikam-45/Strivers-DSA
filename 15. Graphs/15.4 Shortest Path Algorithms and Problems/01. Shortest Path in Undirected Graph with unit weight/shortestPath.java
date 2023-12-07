//question link.
// https://www.codingninjas.com/studio/problems/single-source-shortest-path_8416371?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION

import java.util.*;
public class Solution {
    public static int[] shortestPath(int v, int [][]edges, int src) {
        
        //first created the adjacency list.
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        //number of edges.
        int edge = edges.length;

        //allocate memory.
        for(int i=0; i<v; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }

        //created arraylsist.
        for(int i=0; i<edges.length; i++)
        {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        //created array that stores the resultant ans.
        int dist[] = new int[v];

        //fill the infite value.
        Arrays.fill(dist, (int)1e9);

        //created queue.
        Queue<Integer> queue = new ArrayDeque<>();
        //using the bfs algorithm we solve this ques.
        queue.add(src);

        //added first src to the disttance resultant array.
        dist[src] = 0;

        //we use simple BFS algorithm
        while(queue.size() > 0)
        {
            //remove
            int remove = queue.remove();

            //going to neighbour.
            for(Integer nbr: adjList.get(remove))
            {
                if(dist[remove] + 1 < dist[nbr])
                {
                    dist[nbr] = dist[remove] + 1;
                     queue.add(nbr);
                }
               
            }
        }


        for(int i=0; i<v; i++)
        {
            if(dist[i] == (int)1e9)
            {
                dist[i] =-1;
            }
        }

        return dist;



        


    }
}
