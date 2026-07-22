//question link.
//GFG : https://www.geeksforgeeks.org/problems/check-for-balanced-tree/1
//CN : https://www.naukri.com/code360/problems/is-height-balanced-binary-tree_975497


/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public int height(Node root)
    {
        //base case
        if(root == null) return 0;
        
        int left = 0;
        int right = 0;
        
        left = height(root.left);
        right = height(root.right);
        
        return 1 + Math.max(left , right);
        
    }
    
    public boolean isBalanced(Node root) {
        
        if(root == null) return true;
        
        int left = height(root.left);
        int right = height(root.right);
        
        if((Math.abs(left - right) <= 1 ) &&  isBalanced(root.left) && isBalanced(root.right)) return true;
        
        return false;
        
        
        
    }
}