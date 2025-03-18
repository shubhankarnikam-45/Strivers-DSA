// Move Zero's to End Optimal Way.
//https://www.naukri.com/code360/problems/ninja-and-the-zero-s_6581958?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTabValue=PROBLEM
//https://leetcode.com/problems/move-zeroes/description/


public class Solution {
        public static void swap(int arr[], int i, int j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        public static int[] moveZeros(int n, int []a) {
        
        //creating two pointes.
        int zeroPointer = 0;
        int nonZeroPointer = 0;

        while(nonZeroPointer < n)
        {
            if(a[nonZeroPointer] > 0)
            {
                swap(a, zeroPointer, nonZeroPointer);
                zeroPointer++;
                nonZeroPointer++;
            }
            else
            {
                nonZeroPointer++;
            }
        }

        return a;
    }
}