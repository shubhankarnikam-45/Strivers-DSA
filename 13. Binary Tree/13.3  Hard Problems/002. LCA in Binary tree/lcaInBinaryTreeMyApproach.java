//question link.
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
//https://www.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
//https://www.codingninjas.com/studio/problems/lca-of-binary-tree_920541

/* Structure of binary tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
}
}*/

class Solution {
    boolean lcaHelper(Node root, int n1, int n2, Node found)
    {
        if(root == null) return false; 
        
        if(found.data != -1) return true;
        
       
        boolean leftCall = lcaHelper(root.left, n1, n2, found);
        
        if(found.data != -1) return true ;
        
        if(leftCall == true)
        {
            if(root.data == n1 || root.data == n2){
                found.data = root.data;
                return true;
            }
        }
        
        boolean rightCall = lcaHelper(root.right, n1, n2, found);
        
        if(rightCall == true)
        {
            if(root.data == n1 || root.data == n2){
                found.data = root.data;
                return true;
            }
        }
        
        if(found.data != -1) return true;
        
        if(root.data == n1 || root.data == n2) return true;
        

        //if both are true then update the found and return.
        if(leftCall && rightCall){
            found.data = root.data;
            return true;
        }
        
        return leftCall || rightCall;
    }
    Node lca(Node root, int n1, int n2) {
        
        Node found = new Node(-1);
        
        lcaHelper(root, n1, n2, found);
        return found;
    }
}