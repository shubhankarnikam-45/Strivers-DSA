//question link.
//https://www.naukri.com/code360/problems/can-you-make_4244510?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=PROBLEM


public class usingStiverLongestCommonSubsequenceQuestion {

    public static int lcs(String s, String t) {
		
		//here we use the pattern match / not match.
		int m = s.length();
		int n = t.length();

		//Space optimization.
		int prev[] = new int[n + 1];
		int cur[]  = new int[n + 1];

		//first we write the base case.
		for(int index2 = 0; index2 <=n; index2++) prev[index2] = 0;
		

		for(int index1 = 1; index1 <= m; index1++)
		{
			for(int index2 = 1; index2 <= n; index2++)
			{
				//if string at current index matches.
				if(s.charAt(index1 - 1) == t.charAt(index2 - 1))
				{
					cur[index2] = 1 + prev[index2 - 1];
				}
				else 
				{
					cur[index2] = 0 + Math.max(prev[index2], cur[ index2 - 1]);
				}
				
			}

			 prev = (int[]) (cur.clone());
		}

		return prev[n];
    }

    public static int canYouMake(String s1, String s2) {
        
        int m = s1.length();
        int n = s2.length();

        return m + n - 2 * lcs(s1, s2);
    }
}
