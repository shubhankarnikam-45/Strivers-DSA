//que link: 
//https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2/

class Solution {
    
    //created pair class to store the neighbour node and the weight.
    class Pair
    {
        int nbr;
        int wt;
        
        Pair(int nbr, int wt)
        {
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    
    //function topo sort.
    public void topoSort(ArrayList<ArrayList<Pair>> adjList, boolean visited[], int node, Stack<Integer>st)
    {
        //first make node visited;
        visited[node] = true;
        
        for(Pair p : adjList.get(node))
        {
            int v = p.nbr;
            
            if(visited[v] == false)
            {
                topoSort(adjList, visited, v, st);
            }
        }
        
        //adding node in post order. in stack.
        st.push(node);
        
    }

	public int[] shortestPath(int V,int n, int[][] edges) {
		
		//first created the adjacency list.
		ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
		
		//allocate memory.
		for(int i=0; i<V; i++)
		{
		    adjList.add(new ArrayList<Pair>());
		}
		
		for(int i=0; i<n; i++)
		{
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int w = edges[i][2];
		    
		    adjList.get(u).add(new Pair(v, w));
		}
		
		
		//first we do the topo sort using DFS.
		//created the visited booolean array.
		boolean visited[] = new boolean[V];
		
		//vimp.
// 		visited[0] = true;
		
		// step 1: created stack to store the topo sort.
		Stack<Integer> st = new Stack<>();
		
		for(int i=0; i<V; i++)
		{
		    if(visited[i] == false)
		    {
		        topoSort(adjList, visited, i, st);
		    }
		}
		
		
		//step 2: finding the shrotest distance.
		int dist[] = new int[V];
		
		//fill dist[] array with 1e9
		Arrays.fill(dist, (int)1e9);
		
		dist[0] = 0;
		
		while(st.size() > 0)
		{
		    //pop
		    int top = st.peek();
		    st.pop();
		    
		    //going to neighbour of top.
		    for(Pair p : adjList.get(top))
		    {
		        int v = p.nbr;
		        int w = p.wt;
		        
		        if(dist[top] + w <dist[v])
		        {
		            dist[v] = dist[top] + w;
		        }
		    }
		}
		
		
		for(int i=0; i<V; i++)
		{
		    if(dist[i] == (int)1e9)
		    {
		        dist[i] = -1;
		    }
		}
		
		
		return dist;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}