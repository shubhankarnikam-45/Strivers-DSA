//que link
//https://course.acciojob.com/idle?question=f418b898-6922-4c8a-91f3-9cf060a62957
//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1


import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    public boolean dfs(int node, ArrayList<Integer>[]adj, boolean visited[], boolean[] pathVis)
    {
        visited[node] = true;
        pathVis[node] = true;

        //required vertices.
        ArrayList<Integer> root = adj[node];
        for(Integer num: root)
            {
                if(visited[num] == false)
                {
                    if(dfs(num, adj, visited, pathVis) == true)
                    {
                        return true;
                    }
                }
                else if(pathVis[num] == true)         ///this means we found the cycle
                {
                    return true;
                }
            }
        
        //backtracking.
        pathVis[node] = false;

        //return false
        return false;
    }
public boolean isCyclic(int v, ArrayList<Integer>[] adj) {

    //we using the DFS algorithm
    //created two boolena array one is 'visited' & second is 'path visited'
    boolean[] visited = new boolean[v];
    boolean[] pathVis = new boolean[v];

    for(int i=0; i<v; i++)
        {
            if(dfs(i, adj, visited, pathVis) == true)
            {
                return true;
            }
        }

    //this when no cycle is detect.
    return false;
   }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}