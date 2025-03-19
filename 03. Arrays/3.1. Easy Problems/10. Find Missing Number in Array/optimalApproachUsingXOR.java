//https://www.naukri.com/code360/problems/missing-number_6680467?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTabValue=PROBLEM
//https://leetcode.com/problems/missing-number/description/

public class Solution {
    public static int missingNumber(int []a, int N) {
        
      int XOR1 = 0;
      for(int i=1; i<=N; i++)
      {
          XOR1 = XOR1 ^ i;
      }  

      int XOR2 = 0;
      //array.
      for(int i=0; i<a.length; i++)
      {
          XOR2 = XOR2 ^ a[i];
      }

      return XOR1 ^ XOR2;
    }
}