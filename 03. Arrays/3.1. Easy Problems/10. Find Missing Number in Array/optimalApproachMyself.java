//question link.
//https://www.naukri.com/code360/problems/missing-number_6680467?leftPanelTabValue=PROBLEM
//https://leetcode.com/problems/missing-number/


class Solution {
    public int missingNumber(int[] nums) {
        
        //size of array.
        int n = nums.length;

        //sum of n element.
        int sumOfNElement = (n * (n+1))/2;

        //varaible that store the tatal sum in array.
        int sum = 0;

        //now i traverse in the nums array and find answer.
        for(int i=0; i<nums.length; i++)
        {
            sum += nums[i];
        }

        return sumOfNElement - sum;
    }
}