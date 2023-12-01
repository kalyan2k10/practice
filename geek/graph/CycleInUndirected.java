package geek.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class CycleInUndirected {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>(Arrays.asList(3)));
        adj.add(new ArrayList<>());

        System.out.println("res" + isCycleDir(adj.size(), adj));

    }


    public static boolean isCycleDir(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] v = new boolean[V];
        boolean[] stack = new boolean[V];
        for(int i=0;i<V;i++)
            System.out.println("adj" +adj.get(i));
        boolean res = false;
        for(int i=0;i<V;i++)
            if(!v[i])
                res = res || isCycleDirected(adj,i,v,stack);
        System.out.println("res " + res);
        return res;
    }
    private static boolean isCycleDirected(ArrayList<ArrayList<Integer>> adj, int n, boolean[] visited, boolean[] stack) {
        boolean res = false;
        if(adj.get(n).size() == 0) return false;
        if(adj.get(n).size()>=0) {
            if(!visited[n]) {
                visited[n] = true;
                stack[n] = true;
                System.out.print(n + " ");
                for (int x : adj.get(n)) {
                    res = res || isCycleDirected(adj, x, visited, stack);
                }
            }
            else {
                if(stack[n])
                    return true;
            }
        }
        return res;
    }

    private static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int n, boolean[] visited, int parent) {
        boolean res = false;
        if(adj.get(n).size() == 0) return false;
        if(adj.get(n).size()>=0) {
            if(!visited[n]) {
                visited[n] = true;
                System.out.print(n + " ");
                for (int x : adj.get(n)) {
                    if(x!=parent)
                        res = res || isCycle(adj, x, visited,n);
                }
            }
            else {
                    return true;
            }
        }
        return res;
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> al = new ArrayList<>();
        //System.out.println("V " +V);
        for(int i=0;i<V;i++){
            System.out.println("adj " +adj.get(i));
        }
        LinkedList<Integer> q = new LinkedList<>();
        if(adj.size()==0) return al;
        q.add(0);
        boolean[] visited = new boolean[V];
        while(!q.isEmpty()) {
            int n = q.removeFirst();
            if(!visited[n]){
                visited[n] = true;
                //al.add(n);
                System.out.print(n + " ");
            } else {
                //System.out.println("cycle exists");
                break;
            }
            if(!adj.get(n).isEmpty()) {
                for(int ele: adj.get(n)) {
                    q.addLast(ele);
                }
            }
        }
        return al;
    }
}
