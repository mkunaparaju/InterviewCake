package main.TreesGraphs;

import main.StacksAndQueues.QueueImpl;

import java.util.*;


//Not done complete later again
public class SuperBalancedBinaryTreeRound2 {
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

        ht.height = ((lheight.height > rheight.height) ? lheight.height : rheight.height) + 1;

        return Math.abs(lheight.height - rheight.height) > 1 ? false: l&r;

    }

    boolean isSuperBalancedIterative(BinaryTreeNode root) {
        int maxHeight = -1;
        Queue<NodeDepthPair>  nodeDepthPairQueue = new LinkedList<>();
        nodeDepthPairQueue.offer(new NodeDepthPair(root, 0));

        while(!nodeDepthPairQueue.isEmpty()){
            NodeDepthPair pair = nodeDepthPairQueue.poll();
            if(pair.node.right != null) nodeDepthPairQueue.offer(new NodeDepthPair(pair.node.right, pair.depth+1));
            if(pair.node.left != null) nodeDepthPairQueue.offer(new NodeDepthPair(pair.node.left, pair.depth+1));

            if(pair.node.right == null && pair.node.right == null) {
                if(maxHeight == -1) maxHeight = pair.depth;
                else{
                    if(Math.abs(maxHeight - pair.depth) > 1) return false;
                    else maxHeight = maxHeight > pair.depth ? maxHeight : pair.depth;
                }
            }
        }
        return true;
    }
}


