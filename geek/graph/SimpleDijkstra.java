package geek.graph;

import java.util.Arrays;
import java.util.Collections;

public class SimpleDijkstra {
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
        for(int c=0;c<V-1;c++){
            int u=-1;
            for(int v=0;v<V;v++){
                if(!fin[v] && (u==-1 || dist[v] < dist[u])) {
                    u =v;
                }
            }
            fin[u] = true;
            for(int v=0;v<V;v++){
                if(!fin[v] && m[u][v] !=0){
                    dist[v] = Math.min(dist[v], dist[u] + m[u][v]);
                }
            }
        }
        Arrays.stream(dist).forEach(x -> System.out.print(" " +x));
    }
}
