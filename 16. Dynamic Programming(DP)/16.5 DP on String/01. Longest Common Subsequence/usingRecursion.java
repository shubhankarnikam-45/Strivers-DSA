//question link.
//https://www.naukri.com/code360/problems/longest-common-subsequence_624879?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM



public class usingRecursion {

	public static int fun(int index1, int index2, String s, String t)
	{
		//base case.
		if(index1 < 0 || index2 < 0) return 0;

		//if string at current index matches.
		if(s.charAt(index1) == t.charAt(index2))
		{
			return 1 + fun(index1 - 1, index2 - 1, s, t);
		}

		return 0 + Math.max(fun(index1 - 1, index2, s, t), fun(index1, index2 - 1, s, t));
	}
	public static int lcs(String s, String t) {
		
		//here we use the pattern match / not match.
		int m = s.length();
		int n = t.length();

		return fun(m - 1, n - 1, s, t);
    }

}