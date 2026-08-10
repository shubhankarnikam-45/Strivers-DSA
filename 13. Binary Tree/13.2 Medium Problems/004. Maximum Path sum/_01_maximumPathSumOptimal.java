//question links.
//LC : https://leetcode.com/problems/binary-tree-maximum-path-sum/
//GFG : https://www.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1
//CN :  https://www.naukri.com/code360/problems/maximum-sum-path-of-a-binary-tree._1214968

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

    //helper function.
    public int maxPathSumHelper(TreeNode root, int maxi[])
    {
        //base case.
        if(root == null) return 0;

        //left sum
        int leftSum = Math.max(0, maxPathSumHelper(root.left, maxi));
        int rightSum = Math.max(0, maxPathSumHelper(root.right, maxi));

        maxi[0] = Math.max(maxi[0], root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum , rightSum);

    }
    public int maxPathSum(TreeNode root) {
        
        //created array of size 1 that holds the max.
        int maxi[] = new int[1];
        maxi[0] = Integer.MIN_VALUE;

        maxPathSumHelper(root, maxi);

        return maxi[0];

    }
}