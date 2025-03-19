//question link.
//https://www.naukri.com/code360/problems/missing-number_6680467?leftPanelTabValue=PROBLEM



public class Solution {
    public static int missingNumber(int []a, int N) {
        
        //loop from 1 to n and then check in array.
        //this is brute force approach.
        for(int i=1; i<=N; i++)
        {
            int j = 0;
            for(;j<a.length; j++)
            {
                if(a[j] == i) break;
            }

            if(j == a.length) return i;
        }

        return -1;
    }
}