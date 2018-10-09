package main.TreesGraphs;

import main.PrintingHelper;

import java.util.ArrayList;
import java.util.HashSet;


//Not done complete later again
public class SuperBalancedBinaryTree {
    private static HashSet<Integer> leafDepthSet = new HashSet<>();

    public static void main(String[] args) {
        BuildTree tree = new BuildTree();
        int [] arr =  {1,2,3,4,5,6,7, 8 };
        BinaryTreeNode node = tree.buildBinaryTree(arr);



        getDepths(node,0);
        System.out.println(leafDepthSet.size() + new ArrayList<>(leafDepthSet).get(0));
    }

    private static void getDepths(BinaryTreeNode node, int depth) {
        if(node.left == null && node.right == null) {
            leafDepthSet.add(depth);
        }

        System.out.println(depth);
        depth++;
        if(node.left != null) getDepths(node.left, depth);
        if(node.right != null) getDepths(node.right, depth);
    }
}
