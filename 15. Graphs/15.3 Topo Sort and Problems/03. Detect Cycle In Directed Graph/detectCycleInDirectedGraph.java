import java.util.*;
public class Solution {

    public static class Edge
    {
        int ver;
        int nbr;

        Edge(int ver, int nbr)
        {
            this.ver = ver;
            this.nbr = nbr;
        }
    }
  public static boolean detectCycleInDirectedGraph(int v, ArrayList < ArrayList < Integer >> edges) {
      //first created the adjacency list.

      int e = edges.size();
        ArrayList<Edge>[] graph= new ArrayList[v+1];

        //allocate memory
        for(int i=0; i<=v; i++)
        {
            graph[i] = new ArrayList<Edge>();
        }

        for(int i=0; i<e; i++)
        {
            int v1 = edges.get(i).get(0);
            int v2 = edges.get(i).get(0);

            graph[v1].add(new Edge(v1, v2));
        }


        //created indegree array.
        int inDegree[] = new int[v];

        for(int i=0; i<v; i++)
        {
            for(Edge edge: graph[i])
            {
                inDegree[edge.nbr]++;
            }
        }

        //created quue 
        Queue<Integer> queue = new ArrayDeque<>();

        //traverse added vertex has indegree 0
        for(int i=0; i<v; i++)
        {
            if(inDegree[i] == 0)
            {
                queue.add(i);
            }
        }


        //created arraylist to hold answer.
        List<Integer> ans = new ArrayList<>();

        //now we apply kahn's algorithm.
        while(queue.size() > 0)
        {
            //remove 
            int remove = queue.remove();

            //added to ans arraylist.
            ans.add(remove);

            //now we going to it's children.
            for(Edge edge: graph[remove])
            {
                inDegree[edge.nbr]--;

                //if indegree of this node is 0 then added to queue.
                if(inDegree[edge.nbr] == 0)
                {
                    queue.add(edge.nbr);
                }
            }

        }


        return ans.size() == v;
  }
}