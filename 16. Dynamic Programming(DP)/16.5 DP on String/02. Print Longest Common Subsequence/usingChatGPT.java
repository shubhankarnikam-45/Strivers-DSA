
//this code is correct version of my code i pass all the testcase using charGPT.
//qustion link.
//https://www.geeksforgeeks.org/problems/print-all-lcs-sequences3413/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=print-all-lcs-sequences

//charGPT link.
//https://chatgpt.com/share/66f8e1f0-d89c-8007-94f2-aa8b0c822186

//GFG article link.
//https://www.geeksforgeeks.org/print-longest-common-sub-sequences-lexicographical-order/

// User function Template for Java

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class usingChatGPT {
    
    public List<String> fun(int index1, int index2, String s, String t, List<String>[][] dp) {
        // Base case.
        if(index1 < 0 || index2 < 0) {
            List<String> alist = new ArrayList<>();
            alist.add("");
            return alist;
        }
        
        if(dp[index1][index2].size() != 0) return dp[index1][index2];
        
        // If characters at both indices match.
        if(s.charAt(index1) == t.charAt(index2)) {
            List<String> alist1 = fun(index1 - 1, index2 - 1, s, t, dp);
            List<String> newList = new ArrayList<>();
            for (String str : alist1) {
                newList.add(str + s.charAt(index1)); // append character
            }
            dp[index1][index2] = newList;
            return newList;
        }
        
        // Calculate the two possibilities: ignoring one character from each string.
        List<String> alist2 = fun(index1 - 1, index2, s, t, dp);
        List<String> alist3 = fun(index1, index2 - 1, s, t, dp);
        
        // Merge the lists based on their lengths.
        if(alist2.get(0).length() > alist3.get(0).length()) {
            dp[index1][index2] = alist2;
            return alist2;
        } else if(alist3.get(0).length() > alist2.get(0).length()) {
            dp[index1][index2] = alist3;
            return alist3;
        } else {
            Set<String> mergedSet = new HashSet<>(alist2);
            mergedSet.addAll(alist3);
            List<String> mergedList = new ArrayList<>(mergedSet);
            dp[index1][index2] = mergedList;
            return mergedList;
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
        
        // Use a Set to remove duplicates
        Set<String> set = new HashSet<>(ans);
        ans = new ArrayList<>(set);
        Collections.sort(ans);
        
        return ans;
    }
}