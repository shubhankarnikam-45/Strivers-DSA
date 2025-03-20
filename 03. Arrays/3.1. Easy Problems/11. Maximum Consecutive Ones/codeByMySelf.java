//question link.
//https://leetcode.com/problems/max-consecutive-ones/


class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        //size of array.
        int n = nums.length;

        //this variable we return at last.
        int ans = Integer.MIN_VALUE;

        //varible that store the current sum.
        int sum = 0;
        for(int i=0; i<n; i++)
        {
            if(nums[i] == 0)
            {
                //compare with ans.
                ans = Math.max(ans, sum);
                sum = 0;
            }
            else
            {
                //add to the sum variable.
                sum += 1;
            }
        }

        //this for the case [1 1 1 0 0 1 1 1 1 1]
        ans = Math.max(ans, sum);


        //return answer.
        return ans;
    }
}