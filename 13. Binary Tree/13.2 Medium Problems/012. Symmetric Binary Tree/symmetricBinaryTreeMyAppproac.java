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
    public void findLeftSubtree(Node root, ArrayList<Integer> alist)
    {
        if(root == null) return;
        
        //add to arraylist.
        alist.add(root.data);
        findLeftSubtree(root.left, alist);
        findLeftSubtree(root.right, alist);
    }
    
    public void findRightSubtree(Node root, ArrayList<Integer> alist)
    {
        if(root == null) return;
        
        //add to arraylist.
        alist.add(root.data);
        findRightSubtree(root.right, alist);
        findRightSubtree(root.left, alist);
    }
    public boolean isSymmetric(Node root) {
        
        if(root == null) return true;
        
        //created two arraylist to find the left and right subtree.
        ArrayList<Integer> leftSubtree = new ArrayList<>();
        findLeftSubtree(root.left, leftSubtree);
        ArrayList<Integer> rightSubtree = new ArrayList<>();
        findRightSubtree(root.right, rightSubtree);
        
        if(leftSubtree.size() != rightSubtree.size()) return false;
        
        //traverse and check the element.
        for(int i=0; i<leftSubtree.size(); i++)
        {
            //get both elelemtn
            int data1 = leftSubtree.get(i);
            int data2 = rightSubtree.get(i);
            
            if(data1 != data2) return false;
        }
        
        return true;
    }
}