package geek.tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Stack;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(TreeNode left, TreeNode right, int value){
        this.left = left;
        this.right = right;
        this.value = value;
    }
    public static void main(String[] args){
        TreeNode nine = new TreeNode(null, null, 9);
        TreeNode eight = new TreeNode(null, null, 8);
        TreeNode seven = new TreeNode(null, null, 7);
        TreeNode six = new TreeNode(null, null, 6);
        TreeNode five = new TreeNode(eight, nine, 5);
        TreeNode four = new TreeNode(null, null, 4);
        TreeNode two = new TreeNode(six, seven, 2);
        TreeNode one = new TreeNode(four, five, 1);
        TreeNode three = new TreeNode(one, two, 3);
        //System.out.println(getSize(three));
        /*TreeNode two1 = new TreeNode(null, null, 2);
        TreeNode one1 = new TreeNode(null, null, 1);
        TreeNode three1 = new TreeNode(one1, two1, 3);*/
        //int k=2;
        //printAtK(three,k+1);
        IterativePostorderTraversal(three);
    }
    private static void IterativePostorderTraversal(TreeNode three) {
        TreeNode curr = three;
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.peek();
            if (curr.right == null || curr.right == prev) {
                System.out.print(curr.value + " ");
                st.pop();
                prev = curr;
                curr = null;
            } else {
                curr = curr.right;
            }
        }
    }
    private static void IterativePreorderTraversalGeek(TreeNode three) {
        Stack<TreeNode> st = new Stack<>();
        st.push(three);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            System.out.print(node.value + " ");
            if(node.right!=null) st.push(node.right);
            if(node.left!=null) st.push(node.left);
        }
    }

    private static void IterativePreorderTraversal(TreeNode three) {
        TreeNode curr = three;
        Stack<TreeNode> st = new Stack<>();
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                System.out.print(curr.value + " ");
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            curr = curr.right;
        }
    }

    private static void IterativeInorderTraversal(TreeNode three) {
        TreeNode curr = three;
        Stack<TreeNode> st = new Stack<>();
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.print(curr.value);
            curr = curr.right;
        }
    }

    private static int getSize(TreeNode node) {
        if(node==null) return 0;
        return 1+getSize(node.left) + getSize(node.right);
    }

    private static void leveOrderTraversal(TreeNode three) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.push(three);
        while(!q.isEmpty()){
            TreeNode node = q.removeFirst();
            System.out.print(node.value + " ");

            if(node.left != null) q.addLast(node.left);
            if(node.right != null)  q.addLast(node.right);
        }
    }

    private static int getMax(TreeNode node) {
        if(node==null) return Integer.MIN_VALUE;
        int subRes = Math.max(node.value, getMax(node.left));
        return Math.max(subRes, getMax(node.right));
    }

    private static void printAtK(TreeNode node, int k) {
        if(node==null || k<0) return;
        if(k==0) System.out.print(node.value + " ");
        printAtK(node.left, --k);
        printAtK(node.right, --k);
    }

    private static int height(TreeNode node) {
        if(node==null) return 0;
        return Math.max(1+height(node.left), 1+height(node.right));
    }

    private static void inorder(TreeNode node) {
        if(node==null) return;
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    private static boolean areEqual(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return true;
        if(root1==null && root2!=null) return false;
        if(root1!=null && root2==null) return false;
        return root1.value == root2.value && areEqual(root1.left, root2.left) && areEqual(root1.right, root2.right);
    }
}
