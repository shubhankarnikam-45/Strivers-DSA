class Solution {
    public int fun(int i, int j, List<List<Integer>> triangle, List<List<Integer>> dp)
    {
        if(i == triangle.size() -1)
        {
            return triangle.get(i).get(j);
        }

        if(dp.get(i).size() == j+1) return dp.get(i).get(j);

        int idx =  fun(i + 1, j, triangle, dp);
        int idxp1 =  fun(i + 1, j + 1, triangle, dp);

        int candidate = triangle.get(i).get(j) + Math.min(idx , idxp1);

        dp.get(i).add(candidate);
        return candidate;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        
        ArrayList<Integer> dp =new ArrayList<>();
    
        for(Integer num : triangle.get(triangle.size()-1))
        {
            dp.add(num);
        }

        

        for(int i=dp.size()-2; i>=0; i--)
        {
            ArrayList<Integer> cur = new ArrayList<>();

            for(int j=0; j<i+1; j++)
            {
                int idx =  dp.get(j);
                int idxp1 =  dp.get(j + 1);

                int candidate = triangle.get(i).get(j) + Math.min(idx , idxp1);

                cur.add(candidate);
                
            }

            dp = cur;
        }

        return dp.get(0);
    }
}