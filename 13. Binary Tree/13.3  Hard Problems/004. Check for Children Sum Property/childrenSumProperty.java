//question link.
//https://www.naukri.com/code360/problems/childrensumproperty_790723

import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode < Integer > {
        int data;
        BinaryTreeNode < Integer > left;
        BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/

public class Solution {

    //code for findout the node is leaf node or not.
    public static boolean isLeaf(BinaryTreeNode < Integer > root)
    {
        return root.left == null && root.right == null;
    }
    public static void changeTree(BinaryTreeNode < Integer > root) {
        
        if(root ==  null) return;

        //left node data.
        int leftNodeData = 0;
        int rightNodeData  = 0;

        if(root.left != null) leftNodeData = root.left.data;
        if(root.right != null) rightNodeData = root.right.data;

        //current node data is less that child node data sum then update.
        if(root.data >= leftNodeData + rightNodeData)
        {
            //update left node and right node.
            if(root.left != null)root.left.data = root.data;
            if(root.right != null) root.right.data = root.data;
        }
        else
        {
            root.data = leftNodeData + rightNodeData;
        }


        //to towards right and left node ( or subtree)
        if(root.left != null) changeTree(root.left);
        if(root.right != null) changeTree(root.right);

        //while backtracking update the root node.
        leftNodeData = 0;
        rightNodeData = 0;

        if(root.left != null) leftNodeData = root.left.data;
        if(root.right != null) rightNodeData = root.right.data;

        if(!isLeaf(root))
        {
            root.data = leftNodeData + rightNodeData;
        }


        
    }
}