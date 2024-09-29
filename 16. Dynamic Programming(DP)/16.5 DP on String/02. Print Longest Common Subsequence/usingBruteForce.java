
//this code i  correct using chatGPT and only submit the (25) testcases out of (50);
//question link.
//https://www.geeksforgeeks.org/problems/print-all-lcs-sequences3413/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=print-all-lcs-sequences


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class usingBruteForce
 {
    
    public List<String> fun(int index1, int index2, String s, String t, List<String>[][] dp)
    {
        //base case.
        if(index1 < 0 || index2 < 0) 
        {
            List<String> alist = new ArrayList<>();
            alist.add("");
            return alist;
        }
        
        if(dp[index1][index2].size() != 0) return dp[index1][index2];
        
        //if character at two indexs are matches.
        if(s.charAt(index1) == t.charAt(index2))
        {
            List<String> alist1 = fun(index1 - 1, index2 - 1, s, t, dp);
            List<String> newList = new ArrayList<>();  // create a new list to avoid modifying during iteration
            for (String str : alist1) {
                newList.add(str + s.charAt(index1));   // append the character and add to new list
        }

        return dp[index1][index2] = newList;
            
            // return dp[index1][index2] = alist1;
        }
        
        List<String> alist2 = fun(index1 - 1, index2, s, t, dp);
        List<String> alist3 = fun(index1, index2 - 1, s, t, dp);
        
        
        if(alist3.size() > 0 && alist2.get(0).length() == alist3.get(0).length())
        {
            // for(String str : alist3) alist2.add(str);
            
            
             List<String> mergedList = new ArrayList<>(alist2);  // Create a new list with alist2 elements
            mergedList.addAll(alist3);  // Add all elements from alist3
            
            return dp[index1][index2] = mergedList;
        }
        else if(alist2.size() > 0 && alist2.get(0).length() > alist3.get(0).length())
        {
            return dp[index1][index2]= alist2;
        }
        else
        {
            return dp[index1][index2]= alist3;
        }
    }
    public List<String> all_longest_common_subsequences(String s, String t) {
        
        int m = s.length();
        int n = t.length();
        
        List<String>[][] dp = new ArrayList[m][n];
        // Initialize the ArrayLists at each position in the 2D array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }
        
        List<String> ans = fun(m - 1, n - 1, s, t, dp);
        Set<String> set = new HashSet<>();
        for(String str : ans) set.add(str);
        ans = new ArrayList<>();
        
        for(String str : set) ans.add(str);
        Collections.sort(ans);
        
        return ans;
    }}