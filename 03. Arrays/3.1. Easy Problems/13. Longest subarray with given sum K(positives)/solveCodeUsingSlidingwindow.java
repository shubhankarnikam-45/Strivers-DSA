//this approach used only when array containing 0 and positive numbers.
//question link.
////https://www.naukri.com/code360/problems/longest-subarray-with-sum-k_6682399?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTabValue=PROBLEM

public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        
        //size of array.
        int n = a.length;

        long sum = 0;
        int i = 0;
        int j = 0;

        int ans = 0;
        while(j < n)
        {
            sum += a[j];

            if(sum < k) j++;
            else if(sum == k){
                ans = Math.max(ans, j - i + 1);
                j++;
            }
            else if(sum > k)
            {
                while(sum > k)
                {
                    sum -= a[i];
                    i++;
                }

                if(sum == k)
                {
                    ans = Math.max(ans, j - i + 1);

                }
                j++;
            }
        }


        //return the answer.
        return ans;
    }
}

//TC : O(2N)
//SC : O(1)