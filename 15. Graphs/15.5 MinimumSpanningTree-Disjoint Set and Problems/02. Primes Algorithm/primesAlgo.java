import java.util.*;

class Solution{

    //created the pair class.
    public static class Pair
    {
        int node;
        int dist;

        Pair(int node, int dist)
            {
                this.node = node;
                this.dist = dist;
            }
    }
    static void primMST(List<List<Integer>> graph) {
        //first we have to create the adjacency list.
        int v = graph.size();

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        //alllocate memory.
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<Pair>());

        //creation of adjacency list is stareted.
        for(int i=0; i<graph.size(); i++)
            {
                for(int j=0; j<graph.get(i).size();j++)
                    {
                        if(graph.get(i).get(j) != 0)
                        {
                                adj.get(i).add(new Pair(j, graph.get(i).get(j)));
                                adj.get(j).add(new Pair(i, graph.get(i).get(j)));
                        }
                    }
            }

        //created the priority queue.
        PriorityQueue<Pair> queue = new PriorityQueue<>((x,y)-> x.dist - y.dist);
        //initial state of priority queue.
        queue.add(new Pair(0, 0));
        //creeated visited arrya.
        boolean visited[] = new boolean[v];

        //this stores the min distance.
        int sum = 0;
        
        //at wosrt case priority queue can go for all the Edges.
        // O(E) * Log(E)
        //till queue is empty.
        while(queue.size() > 0)
            {
                //pop
                //Log(E)
                Pair top = queue.remove();
                //extrct remove node and distance.
                int rn = top.node;
                int rd = top.dist;

                //if we already visited then can't do anything. just continue
                if(visited[rn] == true)
                {
                    continue; 
                }

                //mark as visited.
                visited[rn]  = true;
                sum += rd;

                //going to neighbour.
                // O(E)
                //overall O(E*LogE)
                for(Pair nbr: adj.get(rn))
                    {
                        if(visited[nbr.node] == false)
                        {
                            //(Log E)
                            queue.add(new Pair(nbr.node, nbr.dist));
                        }
                    }
            }

        System.out.println(sum);

        //overall time compleixty O(E*LogE) + O(E*LogE) ==> O(E*LogE)

        
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            List<Integer> temp = new ArrayList<>(V);
            for (int j = 0; j < V; j++) {
                temp.add(sc.nextInt());
            }
            graph.add(temp);
        }
        Solution.primMST(graph);
        sc.close();
    }
}
