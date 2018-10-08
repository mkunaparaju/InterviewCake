package main.TreesGraphs;

public class BuildTree {

    public BinaryTreeNode insertLevelOrder(int[] arr, BinaryTreeNode root,
                                 int i)
    {
        // Base case for recursion
        if (i < arr.length) {
            BinaryTreeNode temp = new BinaryTreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
        }
        return root;
    }

    public BinaryTreeNode buildBinaryTree(int [] arr ){
            return insertLevelOrder(arr, new BinaryTreeNode(arr[0]), 0) ;
    }

}

