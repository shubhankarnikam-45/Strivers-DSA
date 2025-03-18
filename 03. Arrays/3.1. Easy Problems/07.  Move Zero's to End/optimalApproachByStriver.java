// Move Zero's to End Optimal Way.
//https://www.naukri.com/code360/problems/ninja-and-the-zero-s_6581958?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTabValue=PROBLEM
//https://leetcode.com/problems/move-zeroes/description/



class Solution {

    public void swap(int i, int j, int nums[])
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void moveZeroes(int[] nums) {
        
        //size of array.
        int n = nums.length;

        //now find the first zero.
        int j = -1;
        for(int i=0; i<n; i++) 
            if(nums[i] == 0)
            {
                j = i;
                break;
            }
        
        if(j == -1) return;

        for(int i = j + 1; i <n ;i++)
        {
            if(nums[i] != 0)
            {
                swap(i, j, nums);
                j++;
            }
        }
    }
}