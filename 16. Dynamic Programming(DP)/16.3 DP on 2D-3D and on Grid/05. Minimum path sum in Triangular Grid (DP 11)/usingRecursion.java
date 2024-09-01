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
        
        List<List<Integer>> dp =new ArrayList<>();
        for(int i=0 ;i< triangle.size(); i++)
        {
            dp.add(new ArrayList<Integer>());
        }

        return fun(0, 0, triangle, dp);
    }
}