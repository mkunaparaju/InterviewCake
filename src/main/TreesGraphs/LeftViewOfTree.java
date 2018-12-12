package main.TreesGraphs;

import javax.sound.sampled.LineEvent;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class LeftViewOfTree {
    BinaryTreeNode root;
    static int maxLevel = 0;
    public static void main(String[] args) {
        BSTChecker tree = new BSTChecker();
        tree.root = new BinaryTreeNode(4);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.right = new BinaryTreeNode(5);
        tree.root.left.left = new BinaryTreeNode(1);
        tree.root.left.right = new BinaryTreeNode(3);

        leftView(tree.root, 1);
    }

    private static void leftView(BinaryTreeNode root, int level) {
        if( root == null) return;

        if(maxLevel < level) {
            System.out.println(root.value);
            maxLevel = level;
        }
        if(root.left!=null) leftView(root.left, level+1);
        if(root.right!=null) leftView(root.right, level+1);
    }
}
