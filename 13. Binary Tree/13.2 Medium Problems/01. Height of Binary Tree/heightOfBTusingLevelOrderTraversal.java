//question link.
//GFG: https://www.geeksforgeeks.org/problems/height-of-binary-tree/1
//CN: https://www.naukri.com/code360/problems/height-of-binary-tree_4609628

/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int height(Node root) {
        
        //base case.
        if(root == null) return 0;
        
        //created queue for the level order traversal.
        Queue<Node> queue = new ArrayDeque<>();
        
        queue.add(root);
        
        //total count
        int count = -1;
        
        while(queue.size() > 0)
        {
            //current size.
            int size = queue.size();
            
            for(int i=0; i<size; i++)
            {
                if(i == 0) count++;
                
                
                //remove
                Node node = queue.remove();
                
                //left
                if(node.left != null) queue.add(node.left);
                
                //right
                if(node.right != null) queue.add(node.right);
            }
        }
        
        
        
        return count;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}