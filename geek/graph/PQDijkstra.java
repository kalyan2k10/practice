package geek.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PQDijkstra {
    public static void main(String[] args){
        int n=4;
        int[][] m = {{0,8,4,0},
                {8,0,3,20},
                {4,3,0,2},
                {0,20,2,0}};
        getDistance(m, 0);
    }

    private static void getDistance(int[][] m, int src) {
        int V = m.length;
        boolean[] fin = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((u,v) -> Integer.compare(dist[u], dist[v]));
        pq.add(src);
        while(!pq.isEmpty()){
            int u = pq.poll();
            fin[u] = true;
            for(int v=0;v<V;v++){
                if(!fin[v] && m[u][v]!=0 && dist[u]+m[u][v] < dist[v]){
                    dist[v] = dist[u]+m[u][v];
                    if(!pq.contains(v)) pq.add(v);
                }
            }
        }
        Arrays.stream(dist).forEach(x -> System.out.print(" " +x));
    }
}
