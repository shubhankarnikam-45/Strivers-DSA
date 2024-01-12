//que link.
//https://course.acciojob.com/idle?question=ea6b2dee-3908-4eda-b379-be147e6aef3e

import java.util.*;

//created the Disjoint Class.
class Disjoint
    {
        //to store teh size.
        List<Integer> size = new ArrayList<>();
        //to store the parent.
        List<Integer> parent = new ArrayList<>();

        //contructor of given class.
        Disjoint(int v)
        {
            for(int i=0; i<v; i++)
                {
                   size.add(1);
                    parent.add(i);
                }
        }

        //find Ultimate parent.
        public int findUparent(int v) 
        {
            //base case
            if(v == parent.get(v))
            {
                return v;
            }

            int ultimateParent = findUparent(parent.get(v));
            parent.set(v, ultimateParent);
            return ultimateParent;     
        }

        //now we perform the union operation.
        public void UnionBySize(int u, int v)
        {
            //ultimate parent of u
            int ult_u = parent.get(u);
            //ultimate parent of v
            int ult_v = parent.get(v);

            //if parent are equal we just return.
            if(ult_u == ult_v)
            {
                return;
            }

            if(size.get(ult_u) < size.get(ult_v))
            {
                //we attach smaller size node to bigger node.
                parent.set(ult_v,ult_u);

                //and increase the size.
                size.set(ult_v, size.get(ult_v) + size.get(ult_u));
            }
            else
            {
                //this else handle the 1. ult_u > ult_v
                                    // 2. ult_u == ult_v
                //cases.
                parent.set(ult_u, ult_v);
                size.set(ult_u, size.get(ult_v) + size.get(ult_u));
            }
        }
        
    }
//creating class Edge.
class Edge implements Comparable<Edge>
    {
        int node;
        int nbr;
        int wt;

        Edge(int node, int nbr, int wt)
        {
            this.node = node;
            this.nbr = nbr;
            this.wt =wt;
        }

        public int compareTo(Edge c)
        {
            return this.wt - c.wt;
        }
    }
class Solution {
    List<Edge> edgeList;
    int V;

    public Solution(int V) {
        this.V = V;
        edgeList = new ArrayList<>();
    }

    public void addEdge(int x, int y, int w) {
        edgeList.add(new Edge(x, y, w));
    }

    public void kruskalsMST() {

        //now we have to create the adjacency list.
        ArrayList<Edge> adjList = new ArrayList<>();

       

        // O(E)
        for(int i=0 ; i<edgeList.size(); i++)
            {
                Edge top = edgeList.get(i);
                int node = top.node;
                int nbr = top.nbr;
                int wt = top.wt;

                adjList.add(new Edge(node, nbr, wt));
                adjList.add(new Edge(nbr, node, wt));
                    
            }


        //create the object of disjoint set.
        Disjoint dis = new Disjoint(V);

        // O(MlogM) //M is number of edges.
        Collections.sort(adjList);

        //this hodl the final weight.
        int finalWeight  = 0;

            //M * 4 * alpha * 2
        for(int i=0; i<adjList.size() ;i++)
            {
                Edge top = adjList.get(i);
                
                int u = top.node;
                int v = top.nbr;
                int wt = top.wt;

                //if u and v contains in differnet compoent.
                if(dis.findUparent(u) != dis.findUparent(v))
                {
                    dis.UnionBySize(u, v);
                    finalWeight += wt;
                }
            }

        //print the weight 
        System.out.println(finalWeight);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        Solution g = new Solution(v);
        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int wt = sc.nextInt();
            g.addEdge(src, dest, wt);
        }

        // Function call
        g.kruskalsMST();
    }
}
