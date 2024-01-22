//imp: 
//question related to 'bellman ford' algorithm is not ask in interview.
//but concept and how algorith works is important.

//que link 
//https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=distance-from-the-source-bellman-ford-algorithm


class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        
        //created the distance array.
        int distance[] = new int[V];
        
        //initilize the distance arry with the 'infinite'
        Arrays.fill(distance, (int)1e8);
        
        //src to src the distance is zero.
        distance[S] = 0;
        
        //now we start 'relaxing edges'
        //length of edges.
        int E = edges.size();
        
        //run loop till 'E'
        for(int i=0; i<V; i++)
        {
            for(ArrayList<Integer> element : edges)
            {
                int u = element.get(0);
                int v = element.get(1);
                int wt = element.get(2);
                
                if(distance[u] != (int)1e8 && distance[u] + wt < distance[v])
                {
                    distance[v] = distance[u] + wt;
                }
            }
        }
        
        
        //to detect if the graph contains the negative cycle or not we not one more iteration. 
        // if if() condition run again the we return array contains the {-1}.
        for(ArrayList<Integer> element : edges)
        {
            int u = element.get(0);
            int v = element.get(1);
            int wt = element.get(2);
            
            if(distance[u] !=(int)1e8 && distance[u] + wt < distance[v])
            {
                int ans[] = {-1};
                return ans;
            }
        }
        
        
        //return the distance array.
        return distance;
        
        
        
    }
}
