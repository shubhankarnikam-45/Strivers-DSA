// que link
//https://www.geeksforgeeks.org/problems/topological-sort/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) 
    {
        // System.out.println(adj);
        
        //created viisted boolean array.
        int visited[] = new int[v];
        Arrays.fill(visited, -1);
        
        //stack craed
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=0; i<v; i++)
        {
            if(visited[i] == -1)
            {
                dfs(adj, visited, st,i);
            }
        }
        
        int i=0;
        while(st.size() > 0)
        {
            visited[i++] = st.pop();
        }
        
        return visited;
        
    }
    
    //dfs function.
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int[]visited, Stack<Integer>st,int src)
    
    {
        visited[src] = 1;
        
        //added neigbour
        for(int i=0;i< adj.get(src).size();i++)
        {
            if(visited[adj.get(src).get(i)] == -1)
            {
                dfs(adj, visited, st, adj.get(src).get(i));
            }
        }
        
        st.push(src);
    }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
