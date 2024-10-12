//question link.
//https://leetcode.com/problems/edit-distance/


class spaceOptimization {


    public int minDistance(String s, String t) {
        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n + 1][m + 1];

        int prev[] = new int[m + 1];
        int cur[] = new int[m + 1];
        
        //first we wriet down the base cases.
        // for(int ind1 = 1; ind1 <=n; ind1++) dp[ind1][0] = ind1;
        for(int ind2 = 1; ind2 <=m; ind2++) prev[ind2] = ind2;

        //tabulation.
        for(int ind1 = 1; ind1 <=n; ind1++)
        {
            for(int ind2 = 0; ind2<=m; ind2++)
            {
                if(ind2 == 0)
                {
                    cur[0] = ind1;
                    continue;
                }

                //if character matches.
                if(s.charAt(ind1 - 1) == t.charAt(ind2 - 1))
                {
                    cur[ind2] = prev[ind2 - 1];
                }
                else
                {
                    cur[ind2] =  1 + Math.min(cur[ind2-1], Math.min(prev[ind2 - 1], prev[ind2]));
                }
            }

            prev = cur.clone();
        }

        return prev[m];
    }
}