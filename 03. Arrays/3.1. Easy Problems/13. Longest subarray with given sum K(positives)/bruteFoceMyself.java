//question link.
//https://www.naukri.com/code360/problems/longest-subarray-with-sum-k_6682399?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTabValue=PROBLEM
//https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k

public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        
        //size of array.
        int n = a.length;
        //this stores the final answer.
        int longSubArr = Integer.MIN_VALUE;

        for(int i=0; i<n; i++)
        {
            //this stoes the current sum to be compare.
            long sum = 0;
            
            for(int j=i; j<n; j++)
            {
                sum+= a[j];
                if(sum == k) longSubArr = Math.max(longSubArr, j - i + 1);
                else if(sum > k) break;
            }
        }

        //finally we return the answer.
        return longSubArr;

    }
}