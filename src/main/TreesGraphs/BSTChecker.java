package main.TreesGraphs;

import java.util.ArrayDeque;

public class BSTChecker {
    BinaryTreeNode root;

    public static void main(String args[])
    {
        BSTChecker tree = new BSTChecker();
        tree.root = new BinaryTreeNode(4);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.right = new BinaryTreeNode(5);
        tree.root.left.left = new BinaryTreeNode(1);
        tree.root.left.right = new BinaryTreeNode(3);

        if (tree.isBSTIterative(tree.root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }

    boolean isBSTRecursive(BinaryTreeNode root ){
        return  isBSTRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTRecursive(BinaryTreeNode root, int minValue, int maxValue) {
        if(root == null ) return true;

        boolean l = isBSTRecursive(root.left, minValue, root.value);
        boolean r = isBSTRecursive(root.right, root.value, maxValue);

        if(root.value <= minValue || root.value >= maxValue) return false;

        return l&r;
    }


    private boolean isBSTIterative(BinaryTreeNode root) {

        NodeBound nb = new NodeBound(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        ArrayDeque<NodeBound> stack = new ArrayDeque<>();
        stack.push(nb);

        while(!stack.isEmpty()){

            NodeBound nodeWithBounds = stack.pop();
            BinaryTreeNode node = nodeWithBounds.node;
            int min = nodeWithBounds.low;
            int max = nodeWithBounds.high;

            if(node.value <= min || node.value >= max) return false;
            if(node.left != null)stack.push(new NodeBound(node.left, min, node.value));
            if(node.right != null)stack.push(new NodeBound(node.right, node.value, max));
        }
        return true;
    }


    boolean isBSTInOrderTraversal(BinaryTreeNode root){
        //impliment later on
        return true;
    }
}

class NodeBound{
    BinaryTreeNode node;
    int low;
    int high;

    NodeBound(BinaryTreeNode node, int low, int high){
        this.node = node;
        this.low = low;
        this.high = high;
    }
}

