//question link
//https://www.naukri.com/code360/problems/longest-subarray-with-sum-k_6682399?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTabValue=PROBLEM
//https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k



import java.util.*;
public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        
        //size of array.
        int n = a.length;

         //the variable where we stor our answer.
         int maxLen = 0;

        //hashmap.
        Map<Long, Integer> map = new HashMap<>();

        //sum variable to store the sum.
        long sum = 0;
        //traverse array 
        for(int i=0; i<n; i++)
        {
            //each time we added current element to the sum
            sum += a[i];

            //if we found the current sum == k
            if(sum == k) maxLen = Math.max(maxLen, i + 1);
            else if(map.containsKey(sum - k) == true)
            {
                //if found the sum-k in the hashmap.
                int idx = map.get(sum - k);

                //we compare with the maxLen
                maxLen = Math.max(maxLen, i - idx);
            }

            //we added current sum and the index to the hashmap 
            //if ans only if it not present previously.
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        
         return maxLen;
    }
}