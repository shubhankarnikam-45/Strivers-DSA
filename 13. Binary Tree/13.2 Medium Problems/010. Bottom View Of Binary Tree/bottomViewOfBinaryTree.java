//question link.
//https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
//https://www.naukri.com/code360/problems/bottom-view-of-binary-tree_893110
//https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

class Solution {
    
    class Pair
    {
        Node node;
        int level;
        
        Pair(Node node, int level)
        {
            this.node = node;
            this.level = level;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        
        //create arraylist.
        ArrayList<Integer> ans = new ArrayList<>();
        
        //if root == null
        if(root == null) return ans;
        
        //create queue for level order traversal.
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 0));
        
        //create treemap.
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        
        
        while(queue.size() > 0)
        {
            //pop.
            Pair pair = queue.remove();
            
            //node.
            Node node = pair.node;
            
            //level
            int level = pair.level;
            
            tmap.put(level, node.data);
            
            //add left and right
            if(node.left != null) queue.add(new Pair(node.left, level - 1));
            if(node.right != null) queue.add(new Pair(node.right, level + 1));
            
        }
        
        //traverse tmap  and add in arraylist.
        for(Map.Entry<Integer,Integer> data : tmap.entrySet())
        {
            int value = data.getValue();
            ans.add(value);
        }
        
        return ans;
    }
}