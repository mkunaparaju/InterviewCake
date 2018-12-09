package main.TreesGraphs;

public class GetSecondHighestNode {
    BinaryTreeNode root;

    public static void main(String[] args) {
        BSTChecker tree = new BSTChecker();
        tree.root = new BinaryTreeNode(4);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.right = new BinaryTreeNode(6);
        tree.root.right.right = new BinaryTreeNode(7);
        tree.root.right.left = new BinaryTreeNode(5);
        tree.root.left.left = new BinaryTreeNode(1);
        tree.root.left.right = new BinaryTreeNode(3);

        GetSecondHighestNode get = new GetSecondHighestNode();
        BinaryTreeNode second = get.getSecondHighest(tree.root, null);
        System.out.println( second.value);
    }

    BinaryTreeNode getSecondHighest(BinaryTreeNode root, BinaryTreeNode parent){
        if (root == null) return null;

        if(root.right != null ){
            parent = root;
            root = root.right;
            System.out.println("root" + root.value +  " parent " + parent.value );
            return getSecondHighest(root, parent);

        }

        else if(root.right == null && root.left == null) {
            return parent;
        }

        else{
            return getHighest(root.left);
        }
    }

    private BinaryTreeNode getHighest(BinaryTreeNode node) {
        if(node == null) return  null;
        if(node.right == null) return node;
        else {
            return getHighest(node.right);
        }

    }

}
