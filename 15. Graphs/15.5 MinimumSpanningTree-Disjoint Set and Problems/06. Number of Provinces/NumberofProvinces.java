//G - 48
//que link
//https://www.geeksforgeeks.org/problems/number-of-provinces/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-provinces


class DisjointSet
{

    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    
    DisjointSet(int v)
    {
        for(int i=0; i<=v; i++)
        {
            parent.add(i);
            size.add(1);
        }
    
    }
    
    public int findUParent(int u)
    {
        if(parent.get(u) == u)
        {
            return u;
        }
        
        int ultParent = findUParent(parent.get(u));
        parent.set(u, ultParent);
        return ultParent;
    }
    
    public void Union(int u, int v)
    {
        int ult_u = findUParent(u);
        int ult_v = findUParent(v);
        
        if(ult_u == ult_v)
        return;
        
        if(size.get(ult_u) < size.get(ult_v))
        {
            parent.set(ult_u, ult_v);
            size.set(ult_v, size.get(ult_u) + size.get(ult_v));
        }
        else
        {
            parent.set(ult_u, ult_v);
            size.set(ult_u, size.get(ult_u) + size.get(ult_v));
        }
    }
}
class Solution {
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        
       
       DisjointSet ds = new DisjointSet(V);
       
       //O(V * V)
       for(int i=0; i<adj.size(); i++)
       {
           for(int j=0; j<adj.get(i).size(); j++)
           {
               if(adj.get(i).get(j) == 1)
               {
                //   O(4*alpha)

                //here important is only i - j not j - i this is discared.
                   ds.Union(i, j);
               }
           }
       }
       
       int count = 0;
       
    //   O(V)
       for(int i=0; i<V; i++)
       {
            if(ds.parent.get(i) == i)
            {
                count++;
            }
       }
        
        return count;
        
    }
};