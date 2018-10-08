package main.TreesGraphs;

import java.util.HashSet;

public class SuperBalancedBinaryTree {
    private static HashSet<Integer> leafDepthSet = new HashSet<>();

    public static void main(String[] args) {
        BuildTree tree = new BuildTree();
        int [] arr =  {1,2,3,4,5,6,7};
        BinaryTreeNode node = tree.buildBinaryTree(arr);
    }

    private static void getDepths(BinaryTreeNode node) {
        
    }
}
