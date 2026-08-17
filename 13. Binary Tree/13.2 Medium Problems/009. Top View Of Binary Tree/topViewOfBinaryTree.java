//question link.
//https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    
    //create pair class
    class Pair
    {
        int level;
        Node node;
        
        Pair(int level, Node node)
        {
            this.level = level;
            this.node = node;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        
        //craeted arraylist to  return.
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root == null) return ans;
        
        //created treemap.
        Map<Integer, Integer> tmap = new TreeMap<>();
        
        //create queue for level order traversal.
        Queue<Pair> queue = new ArrayDeque<>();
        
        //add root node.
        queue.add(new Pair(0, root));
        
        //level order traversal.
        while(queue.size() > 0)
        {
            //pop the node.
            Pair pair = queue.remove();
            
            //level
            int level = pair.level;
            
            //node.
            Node node = pair.node;
            
            //check level is present or not.
            if(tmap.containsKey(level) == false) tmap.put(level, node.data);
            
            //add left and right.
            if(node.left != null) queue.add(new Pair(level - 1, node.left));
            if(node.right != null) queue.add(new Pair(level + 1, node.right));
        }
        
        //traverse treemap and store in arraylist.
        for(Map.Entry<Integer, Integer> data : tmap.entrySet())
        {
            int value = data.getValue();
            
            //add in the arraylist.
            ans.add(value);
        }
        
        return ans;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}