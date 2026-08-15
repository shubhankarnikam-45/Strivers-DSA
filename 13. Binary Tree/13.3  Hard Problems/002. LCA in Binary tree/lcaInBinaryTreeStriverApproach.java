//question link.
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
//https://www.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
//https://www.codingninjas.com/studio/problems/lca-of-binary-tree_920541


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null || root ==  p || root == q) return root;

        //leftNode.
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);

        //rightNode
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if(leftNode == null) return rightNode;
        else if(rightNode == null) return leftNode;
        else  return root;
    }
}