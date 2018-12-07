package main.TreesGraphs;

import javax.xml.soap.Node;
import java.util.HashSet;


//Not done complete later again
public class SuperBalancedBinaryTree {
    private static HashSet<Integer> leafDepthSet = new HashSet<>();

    public static void main(String[] args) {
        BuildTree tree = new BuildTree();
        int [] arr =  {1,2,3,4,5,6,7, 8 };
        BinaryTreeNode node = tree.buildBinaryTree(arr);


    }

    boolean isSuperBalancedRecursive(BinaryTreeNode root, Height ht){
        Height lheight = new Height();
        Height rheight = new Height();

        boolean l = isSuperBalancedRecursive(root.left, lheight);
        boolean r = isSuperBalancedRecursive(root.right, rheight);

        int lh = lheight.height;
        int rh = rheight.height;;

        ht.height = (lh>rh)? lh : rh + 1;

        if(Math.abs(lh-rh) > 1) return false;
        else return l&r;
    }

    boolean isSuperBalancedIterative(BinaryTreeNode root){
        return false;
    }

}

class Height{
    int height = 0;
}
