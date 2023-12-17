//que link: 
//https://course.acciojob.com/idle?question=07f39ba2-d302-49aa-8b8d-527038e4f2d5

import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int arr[][] = new int[e][3];
        for (int i = 0; i < e; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        int src = sc.nextInt();
        int dst = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        int ans = Obj.findCheapestPrice(n, arr, src, dst, k);
        System.out.println(ans);
        sc.close();
    }
}

class Solution {
    class Pair
        {
            int node;
            int dist;

            Pair(int node, int dist)
            {
                this.node = node;
                this.dist = dist;
            }
        }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        if(src == dst)
        {
            return 0;
        }
        //creating the adjacency list.
        ArrayList<Pair> adjList []= new ArrayList[n];

        //number of flights.
        int fli = flights.length;
        
        //allocate memory.
        for(int i=0; i<n; i++)
            {
                adjList[i] = (new ArrayList<Pair>());
            }

        for(int i=0; i<fli; i++)
            {
                adjList[flights[i][0]].add(new Pair(flights[i][1], flights[i][2]));
            }


        //created one distance array.
        int distance[] = new int[n];
        //src to src is zero.
        distance[src] = 0;

        //initialze the distance array with maximum number.
        for(int i=0; i<n;i++)
            {
                distance[i] = Integer.MAX_VALUE;
            }

        //created queue 
        Queue<Pair> queue = new ArrayDeque<>();
        //initial position.
        queue.add(new Pair(src,0));

        //this stores the stops.
        int stops = 0;
        //we using the simple BFS
        while(queue.size() > 0 && stops <=k)
            {
                //size
                int size = queue.size();
                
                for(int i=0; i<size; i++)
                    {
                        //pop
                        Pair remove =  queue.remove();
                        int node = remove.node;
                        int dist = remove.dist;

                        //going to neighbour.
                        for(Pair p: adjList[node])
                            {
                                int n1 = p.node;
                                int d = p.dist;

                                if(distance[n1] > d + dist)
                                {
                                    distance[n1] = d + dist;
                                    queue.add(new Pair(n1, d +dist));
                                }
                            }
                    }

                //increas the level
                stops +=1;
            }


        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];






        
    }
}