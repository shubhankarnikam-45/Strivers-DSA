//question link.
//https://leetcode.com/problems/symmetric-tree/description/
//https://www.geeksforgeeks.org/problems/symmetric-tree/1
//https://www.naukri.com/code360/problems/symmetric-tree_981177

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    public  boolean isSymmetric(Node leftNode, Node rightNode)
    {
        if(leftNode == null || rightNode == null) return leftNode == rightNode;
        
        return (leftNode.data == rightNode.data) && (isSymmetric(leftNode.left, rightNode.right)) && (isSymmetric(leftNode.right, rightNode.left));
    }
    public boolean isSymmetric(Node root) {
       
       return isSymmetric(root.left, root.right);
        
    }
}