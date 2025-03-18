// Move Zero's to End
//https://www.naukri.com/code360/problems/ninja-and-the-zero-s_6581958?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTabValue=PROBLEM
//https://leetcode.com/problems/move-zeroes/description/

import java.util.*;
public class Solution {
        public static int[] moveZeros(int n, int []a) {
        
        //arraylist for storing the non-zero element.
        List<Integer> nonZeroArr = new ArrayList<>();

        //now traverse array and store the non-zero element in the arraylist.
        for(int num : a)
        {
            if(num !=0)
                nonZeroArr.add(num);
        }

        //now create array of size n.
        //and then return.
        int ans[] = new int[n];

        //now traverse arraylist and store inthe ans.
        for(int i=0; i<nonZeroArr.size(); i++)
        {
            //current element
            int num = nonZeroArr.get(i);
        ans[i] = num;
        }

        return ans;
    }
}