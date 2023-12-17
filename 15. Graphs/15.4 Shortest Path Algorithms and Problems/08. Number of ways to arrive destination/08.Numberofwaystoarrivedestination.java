//que link: 
// https://course.acciojob.com/idle?question=1130ab43-b03e-4002-8f9a-877ecd02cbd0
//leetcode
//

import java.util.*;
import java.io.*;
import java.lang.*;
@SuppressWarnings("unchecked")
class Solution{
    //creating pair class.
    public static class Pair
        {
            int road;
            int dist;

            Pair(int road, int dist)
            {
                this.road = road;
                this.dist = dist;
            }
        }
    public static int countPaths(int n, int[][] roads){

        //this question solve using the simple BFS

        //number of roads.
        int nor = roads.length;
        //creating the simple adjacency list.
        ArrayList<Pair>[] adj= new ArrayList[n];

        //allocate memory.
        for(int i=0; i<n; i++)
            {
                adj[i] = new ArrayList<Pair>();
            }

        for(int i=0; i<nor; i++)
            {
                adj[roads[i][0]].add(new Pair(roads[i][1],roads[i][2]));
                adj[roads[i][1]].add(new Pair(roads[i][0],roads[i][2]));
            }

        //now crearing queue
        PriorityQueue<Pair> queue = new PriorityQueue<>((x,y)-> x.dist - y.dist);
        queue.add(new Pair(0, 0));

        //creatign distance array.
        int distance[] = new int[n];
        int ways[] = new int[n];
        distance[0] = 0;
        ways[0] =1;

        Arrays.fill(distance, (int)1e9);

    

        int mod = (int)(1e9 + 7);
        
        while(queue.size() > 0)
            {
                //pop
                Pair remove =  queue.remove();
                int r = remove.road;
                int d = remove.dist;

                //going to neighbour.
                for(Pair p: adj[r])
                    {
                        //remove node and distance.
                        int rn = p.road;
                        int rd = p.dist;

                        if(distance[rn] > rd + d)
                        {
                            distance[rn] = rd +d;
                           ways[rn] =  ways[r] % mod; 
                            queue.add(new Pair(rn, rd + d));
                        }
                        else if(distance[rn] == rd + d)
                        {
                           
                            ways[rn] = (ways[rn] + ways[r]) % mod;
                        }
                    }
            }

        return ways[n-1] % mod ;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[m][3];
        for(int i = 0 ; i < m ; ++i){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();

        }
        System.out.print(Solution.countPaths(n,edges));
    }
}