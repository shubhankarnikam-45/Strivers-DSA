
//question link.
//https://www.naukri.com/code360/problems/find-the-single-element_6680465?leftPanelTabValue=SUBMISSION
//https://leetcode.com/problems/single-number/description/


class Solution {
    public int singleNumber(int[] nums) {
        
        int XOR = 0;
        for(int i=0; i<nums.length; i++)
        {
            XOR ^= nums[i];
        }
        
        return XOR;
    }
}

//TC : O(n)
//SC : O(1)