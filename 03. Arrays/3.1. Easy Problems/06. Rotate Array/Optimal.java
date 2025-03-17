//question link.
//https://leetcode.com/problems/rotate-array/description/


class Solution {
    //code for the reverse.
    public void reverse(int nums[], int left, int right)
    {
        if( left > right ||left < 0 || right <0) return;
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        reverse(nums, left+1, right-1);
    }
    public void rotate(int[] nums, int k) {
        
        //size of array
        int n = nums.length;

        reverse(nums, 0, n-(k%n)-1);
        reverse(nums, n-(k %n), n-1);
        reverse(nums, 0, n-1);
    }
}