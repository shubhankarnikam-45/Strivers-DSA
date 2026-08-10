//question link.
//https://www.naukri.com/code360/problems/path-in-a-tree_3843990?leftPanelTabValue=PROBLEM


import java.util.* ;
import java.io.*; 
/*   
    Following is the Binary Tree node structure for referance:

    class TreeNode
    {
        int data;
        TreeNode left, right;
    
        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
*/

public class Solution {
    public static boolean helper(TreeNode root, int x, ArrayList<Integer> alist)
    {
        if(root == null) return false;

        //add the cur node.
        alist.add(root.data);

        //found
        if(root.data == x) return true;

        //go towards left and right.
        if ((helper(root.left, x, alist)) || (helper(root.right, x, alist))) return true;

        //remove node from alist.
        alist.remove(alist.size() - 1);

        //return false means we not node x tilln ow
        return false;        

    }
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {

        //created arraylist to return  answer.
        ArrayList<Integer> ans = new ArrayList<>();

        helper(root, x, ans);

        return ans;



    }
}