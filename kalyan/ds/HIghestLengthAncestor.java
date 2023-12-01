package kalyan.ds;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.List;

class Node {
    int a;
    List<Node> neighbors = new ArrayList<>();
    public Node(int a, List<Node> parentList) {
        this.a = a;
        if(parentList == null) parentList = new ArrayList<>();
        this.neighbors = parentList;
    }
    public String toString() {
        return String.valueOf(this.a);
    }
    public Node(int a) {
        this.a = a;
    }
}
public class HIghestLengthAncestor {
    public static void main(String[] args){

        /*Node six = new Node(6, null);
        Node four = new Node(4, new ArrayList<>(List.of(six)));
        Node two = new Node(2, new ArrayList<>(List.of(four)));
        Node one = new Node(1, null);
        Node three = new Node(3, new ArrayList<>(List.of(one,two)));*/


        Node six = new Node(6, null);
        Node five = new Node(5,  new ArrayList<>(List.of(six)));

        Node four = new Node(4, new ArrayList<>(List.of(five)));
        Node two = new Node(2,  new ArrayList<>(List.of(four)));
        Node one = new Node(1, null);
        Node three = new Node(3, new ArrayList<>(List.of(one,two)));
        List<Node> al = new ArrayList<>();
        al.add(null);al.add(one);al.add(two);al.add(three);
        al.add(four);al.add(five);al.add(six);

        /*List<Node> al = new ArrayList<>();
        getHighestLengthAncestor(three,al);
        for(Node node: al){
            System.out.print(" " + node.a);
        }*/



        //System.out.println(areEqual(three, three1));
        boolean[] visited = new boolean[7];
        visited[0] = true;
        int cnt=1;
        DFS(three, visited);
        for(int i=1;i<visited.length;i++) {
            if(!visited[i]) {
                cnt++;
                DFS(al.get(i), visited);
            }
        }
        System.out.println("len " + cnt);
        List<Node> neighbors = new ArrayList<>();
        visited = new boolean[7];
        visited[0] = true;
        System.out.println(maxNeighbor(three, visited, neighbors));
        System.out.println(neighbors);
    }

    private static int maxNeighbor(Node node1, boolean[] visited, List<Node> neighbors) {
        if(node1 == null ) return 0;
        int res = 0;
        if(node1.neighbors.size()>=0) {
            if(!visited[node1.a]) {
                visited[node1.a] = true;
                neighbors.add(node1);
                List<Node> prevList = null;
                //System.out.println(node1.a);
                for (Node x : node1.neighbors) {
                    List<Node> tempList = new ArrayList<>();
                    res = Math.max(res, 1+maxNeighbor(x, visited, tempList));
                    prevList = new ArrayList<>();
                    prevList.addAll(tempList);
                    if(tempList.size() > prevList.size()){
                        prevList.clear();
                        prevList.addAll(tempList);
                    }
                }
                if(prevList!=null)
                    neighbors.addAll(prevList);
            }
            else {
                System.out.println("cycle exists");
            }
        }
        return res;
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

    private static boolean areEqual(Node node1, Node node2) {
        if(node1 == null && node2 == null) return true;
        if(node1==null && node2!=null) return false;
        if(node1!=null && node2==null) return false;
        boolean cond = node1.a == node2.a;
        if(node1.neighbors == null &&  node2.neighbors == null && cond) return true;
        boolean res = true;
        if(node1.neighbors.size() == node2.neighbors.size() && cond) {
            for(int i = 0; i<node1.neighbors.size(); i++) {
                res = res && areEqual(node1.neighbors.get(i), node2.neighbors.get(i));
            }
        } else {
            return false;
        }
        return res;
    }
    private static int getHighestLengthAncestor(Node input, List<Node> al) {
        if(input == null) return 0;
        if(input.neighbors ==null) return 0;
        int res = Integer.MIN_VALUE;
        for(Node node : input.neighbors){
            List<Node> subList = new ArrayList<>();
            int subRes = 1 + getHighestLengthAncestor(node, subList);
            if(subRes > res) {
                res = subRes;
                subList.add(node);
            }
            if(subList.size()>al.size()){
                al.clear();
                al.addAll(subList);
            }
        }
        return res;
    }
}
