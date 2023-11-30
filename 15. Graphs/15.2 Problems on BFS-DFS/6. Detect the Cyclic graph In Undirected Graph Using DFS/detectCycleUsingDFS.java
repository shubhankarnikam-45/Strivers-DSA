
//queu link
//https://www.codingninjas.com/studio/problems/detect-cycle-in-an-undirected-graph-_758967?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf


import java.util.List;
public class Solution {
    static class Graph {

        // creating pair class.

        boolean dfs(List<List<Integer>>adj, boolean visited[],int node,int parent)
        {
            visited[node] = true;

            for(Integer num: adj.get(node))
            {
                if(visited[num] == false)
                {
                    if(dfs(adj, visited, num, node) == true)
                    {
                        return true;
                    }
                    
                    
                }
                else if(parent != num)
                {
                    return true;
                }
            }

            return false;


        }
        boolean detectCycle(int v, List<List<Integer>> adj) {
            
            boolean visited[] =  new boolean[v+1];


            for(int i=0;i<v;i++)
            {
                if(visited[i] == false)
                {
                    if(dfs(adj,visited,i,-1))
                    {
                        return true;

                    }
                }
            }

            return false;

        }
    };
}
