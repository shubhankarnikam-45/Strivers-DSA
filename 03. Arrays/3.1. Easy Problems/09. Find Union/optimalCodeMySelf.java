//https://www.naukri.com/code360/problems/sorted-array_6613259?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTabValue=PROBLEM


import java.util.*;
public class Solution {
    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here

        int i=0;
        int j=0;

        int n = a.length;
        int m = b.length;
        
        List<Integer> al = new ArrayList<>();


        while(i < n && j < m)
        {
            if(a[i] < b[j])
            {
                if(al.size()==0 || al.get(al.size() -1) != a[i])
                {
                    al.add(a[i]);
                }
                i++;
            }
            else
            {
                if(al.size()==0 || al.get(al.size() -1) != b[j])
                {
                    al.add(b[j]);
                }
                j++;
            }
        }

        
        while(i < n)
        {
                if(al.size()==0 || al.get(al.size() -1) != a[i])
                {
                    al.add(a[i]);
                }
                i++;
        }

        
        while(j < m)
        {
            
                if(al.size()==0 || al.get(al.size() -1) != b[j])
                {
                    al.add(b[j]);
                }
                j++;
        }


        return al;

    }
}