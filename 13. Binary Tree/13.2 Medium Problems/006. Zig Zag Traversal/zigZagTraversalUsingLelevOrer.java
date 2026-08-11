//question link.
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
//https://www.geeksforgeeks.org/problems/zigzag-tree-traversal/1
//https://www.naukri.com/code360/problems/zigzag-binary-tree-traversal_920532



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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();

        //if root is null.
        if(root == null) return ans;

        //create queue.
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        boolean leftToRight = true;

        while(queue.size() > 0)
        {   
            //size.
            int size = queue.size();

            //created array of size size.
            Integer temp[] = new Integer[size];

            for(int i = 0; i<size; i++)
            {
                //remove.
                TreeNode node = queue.remove();

                int index = (leftToRight) ? (i) : (size - 1 - i);

                temp[index] = node.val;

                //add left node
                if(node.left != null) queue.add(node.left);

                //righ node.
                if(node.right != null) queue.add(node.right);
            }

            ans.add(Arrays.asList(temp));

            leftToRight = !leftToRight;
        }
        return ans;
    }
}