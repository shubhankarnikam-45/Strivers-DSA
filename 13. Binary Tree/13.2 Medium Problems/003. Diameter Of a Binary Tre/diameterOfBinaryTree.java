//question link.
//https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1
//https://leetcode.com/problems/diameter-of-binary-tree/submissions/2116322332/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int height(TreeNode root, int ans[])
    {
        if(root == null) return 0;

        int leftHeight = height(root.left, ans);
        int rightHeight = height(root.right, ans);

        ans[0] = Math.max(ans[0], leftHeight + rightHeight);


        return 1 + Math.max( leftHeight,rightHeight);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        
        int ans[] = new int[1];

        height(root, ans);

        return ans[0];
    }
}