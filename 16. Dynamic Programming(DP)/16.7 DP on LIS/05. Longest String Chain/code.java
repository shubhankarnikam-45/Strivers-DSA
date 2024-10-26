//question link
//https://www.geeksforgeeks.org/problems/longest-string-chain/1
//https://leetcode.com/problems/longest-string-chain/solutions/4080755/video-solution-explanation-with-drawings-in-depth-c-java/

class Solution{
    public boolean checkPossible(String s1, String s2)
    {
        //here s1 is bigger and 
        //     s2 is smaller.
        if(s1.length() != s2.length() + 1) return false;
        
        int i = 0;  //points to the string s1
        int j = 0;  //points to the sring s2
        
        while(i < s1.length())
        {
            if(j < s2.length() && s1.charAt(i) == s2.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        
        if(i == s1.length() && j == s2.length()) return true;
        return false;
    }
    public int longestChain(int N, String words[]){
        
        //sort the words array using lambda expression.
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        //creating dp[] array that stores the length.
        int dp[] = new int[N];
        
        //that return the final max value.
        int maxi = 1;
        
        for(int i=0; i<N; i++)
        {
            dp[i] = 1;
            for(int prev = 0; prev < i; prev++)
            {
                if(checkPossible(words[i], words[prev]) && dp[i] < dp[prev] + 1)
                {
                    dp[i] = dp[prev] + 1;
                }
            }
            
            if(maxi < dp[i]) maxi = dp[i];
        }
        
        //return the final answer.
        return maxi;
        
    }
}