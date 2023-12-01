package kalyan.ds;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectDirectedGraph {
    public static void main(String[] args){
        /*Node zero = new Node(0, null);
        Node three = new Node(3, new ArrayList<>(List.of(zero)));
        Node two = new Node(2, new ArrayList<>(List.of(three)));
        Node one = new Node(1, new ArrayList<>(List.of(two)));
        zero.neighbors.add(one);*/

        Node zero = new Node(0, null);
        Node three = new Node(3, null);
        Node two = new Node(2, null);
        Node one = new Node(1, null);
        zero.neighbors.add(one);
        one.neighbors.add(two);
        three.neighbors.add(two);
        //two.neighbors.add(zero);
        List<Node> al = new ArrayList<>();
        al.add(zero);al.add(one);al.add(two);al.add(three);
        System.out.println(isCycle(al));
        boolean[] visited = new boolean[al.size()];
        //DFS(zero, visited);
    }
    public static boolean isCycle(List<Node> al) {
        int n = al.size();
        boolean[] visited = new boolean[n];
        boolean[] rest = new boolean[n];
        for(int i=0;i<visited.length;i++) {
            if(!visited[i]) {
                if(DFSDG(al.get(i), visited, rest) == true)
                    return true;
            }
        }
        return false;
    }
    private static boolean DFSDG(Node node, boolean[] visited, boolean[] rest) {
        if(node == null ) return false;
        boolean cond = false;
        if(node.neighbors.size()>=0) {
            if(!visited[node.a]) {
                visited[node.a] = true;
                rest[node.a] = true;
                System.out.println(node.a);
                for (Node x : node.neighbors) {
                    cond = cond || DFSDG(x, visited, rest);
                }
                rest[node.a] = false;
            }
            else {
                if(rest[node.a])
                    return true;
            }
        }
        return cond;
    }

    private static void DFS(Node node1, boolean[] visited) {
        if(node1 == null ) return;
        if(node1.neighbors.size()>=0) {
            if(!visited[node1.a]) {
                visited[node1.a] = true;
                System.out.println(node1.a);
                for (Node x : node1.neighbors) {
                    DFS(x, visited);
                }
            }
            else {
                System.out.println("cycle exists");
            }
        }
    }
}

