package kalyan.ds;

import java.util.*;

public class BFSearch {
    public static void main(String[] args){
        int n = 8;
        Node eight = new Node(8, null);
        Node seven = new Node(7,  new ArrayList<>(List.of(eight)));
        Node six = new Node(6, null);
        Node four = new Node(4, new ArrayList<>(List.of(six)));
        Node two = new Node(2, new ArrayList<>(List.of(four)));
        Node one = new Node(1, new ArrayList<>(List.of(seven,eight)));
        Node three = new Node(3, new ArrayList<>(List.of(one)));

        List<Node> al = new ArrayList<>();
        al.add(null);al.add(one);al.add(two);al.add(three);
        al.add(four);al.add(null);al.add(six);al.add(seven);al.add(eight);
        //Node clonedNode = clone(three, new HashMap<>());

        boolean[] visited = new boolean[9];
        visited[5] = true;
        BFS(three, visited);
        int count = 1;
        for(int i=1;i<visited.length;i++) {
            if(!visited[i]) {
                count++;
                BFS(al.get(i), visited);
            }
        }
        System.out.println("length " + count);
    }



    private static Node clone(Node input, Map<Node,Node> mp) {
        if(input == null) return null;
        if(mp.containsKey(input)) return mp.get(input);
        Node newNode = new Node(input.a);
        for(Node neighbor : input.neighbors){
            newNode.neighbors.add(clone(neighbor,mp));
        }
        return newNode;
    }
    private static void BFS(Node input,  boolean[] visited) {
        LinkedList<Node> q = new LinkedList<>();
        if(input == null) return;
        q.add(input);

        while(!q.isEmpty()) {
            Node node = q.removeFirst();
            if (!visited[node.a]) {
                visited[node.a] = true;
                System.out.print(node.a + " ");
             } else {
                System.out.println("cycle exists");
                break;
            }
            if(node.neighbors != null) {
                for (Node c : node.neighbors) {
                    q.addLast(c);
                }
            }

        }
    }
}
