//question link.
//https://www.naukri.com/code360/problems/minimum-insertions-to-make-a-string-palindrome_985293?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION
//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/submissions/1408080988/


import java.util.*;
public class usingSpaceOptimization {
    
    public static int minInsertion(String s) {

        //SPACE OPTIMIZATION

        int m = s.length();
        int dp[][] = new int[m][m];

        int prev[] = new int[m];
        int cur[] = new int[m];

        for(int left = m - 1; left>=0; left--)
        {
            for(int right = 0; right <m; right++)
            {
                if(left == right || left > right) continue;

                if(s.charAt(left) == s.charAt(right))   cur[right] = 0 + prev [right - 1];
                else cur[right] = Math.min( ( 1 + prev[right]),( 1 + cur[right - 1]));
            }
             prev = cur.clone();
            
        } 

        return prev[m-1];

    }
}