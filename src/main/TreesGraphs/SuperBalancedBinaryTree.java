package main.TreesGraphs;

import javax.xml.soap.Node;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


//Not done complete later again
public class SuperBalancedBinaryTree {
    private static HashSet<Integer> leafDepthSet = new HashSet<>();

    public static void main(String[] args) {
        BuildTree tree = new BuildTree();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        BinaryTreeNode node = tree.buildBinaryTree(arr);


    }

    boolean isSuperBalancedRecursive(BinaryTreeNode root, Height ht) {
        Height lheight = new Height();
        Height rheight = new Height();

        boolean l = isSuperBalancedRecursive(root.left, lheight);
        boolean r = isSuperBalancedRecursive(root.right, rheight);

        int lh = lheight.height;
        int rh = rheight.height;
        ;

        ht.height = (lh > rh) ? lh : rh + 1;

        if (Math.abs(lh - rh) > 1) return false;
        else return l & r;
    }

    boolean isSuperBalancedIterative(BinaryTreeNode root) {
        List<Integer> depths = new ArrayList<Integer>();
        ArrayDeque<NodeDepthPair>  stack = new ArrayDeque<>();
        if (root == null) return true;
        stack.push(new NodeDepthPair(root, 0));

        while (!stack.isEmpty()) {
            NodeDepthPair pair = stack.pop();
            BinaryTreeNode node = pair.node;
            int depth = pair.depth;

            if (node.left == null && node.right == null) {
                if (!depths.contains(depth)) depths.add(depth);
            }
            if (depths.size() > 2 || (depths.size() == 2 && Math.abs(depths.get(0) - depths.get(1)) > 1)) return false;

            else {
                if (node.left != null) stack.push(new NodeDepthPair(node.left, depth + 1));
                if (node.right != null) stack.push(new NodeDepthPair(node.right, depth + 1));
            }
        }

        return true;
    }
}

class NodeDepthPair {
    BinaryTreeNode node;
    int depth;

    NodeDepthPair(BinaryTreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class Height {
    int height = 0;
}



