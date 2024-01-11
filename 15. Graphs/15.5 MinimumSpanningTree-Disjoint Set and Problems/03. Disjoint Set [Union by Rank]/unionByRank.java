import java.util.*;

public class Main {
  
  public static class DisjointSet
  {
    //this stores the ultimate parent.
    ArrayList<Integer> parent = new ArrayList<>();
    //this store the rank.
    ArrayList<Integer> rank = new ArrayList<>();
    
    //constructor.
    DisjointSet(int n)
    {
      for(int i=0; i<=n; i++)
      {
        parent.add(i);
        rank.add(0);
      }
    }
    
    //their are two important functionalities.
    // 1. findPar()
    // 2. UnionByRank()
    
    public int findPar(int node)
    {
      //base case.
      if(node == parent.get(node)) //this means this is ultmate parent to all.
      {
        return node;
      }
      
      //this step of path compression.
      //this will reduce the time complexity.
      int ultimateParent = findPar(parent.get(node));
      parent.set(node, ultimateParent);
      return ultimateParent;
    }
    
    public void unionByRank(int u, int v)
    {
      //finding the ultimate parent of u and v
      int upu = findPar(u);
      int upv = findPar(v);
      
      //if prent is same that means it belongs to same compnene.
      if(upu == upv) return;
      
      if(rank.get(upu) < rank.get(upv))
      {
        //now we set parent of u as v.
        parent.set(upu, upv);
      }
      else if(rank.get(upv) < rank.get(upu))
      {
        //now we parent of v as u
        parent.set(upv,upu);
      }
      else
      {
        //this means rank are same.
        //we attach u to v or v to u.
        
        parent.set(upv, upu);
        //ultimate parent of u.
        int rankU = rank.get(upu);
        
        //update the rank array.
        rank.set(upu, rankU + 1);
        
        
      }
    }
  }
  public static void main(String[] args) {
       DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);
        
        // if 3 and 7 same or not
        if (ds.findPar(3) == ds.findPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
            
            ds.unionByRank(3, 7);
        if (ds.findPar(3) == ds.findPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
  }
}