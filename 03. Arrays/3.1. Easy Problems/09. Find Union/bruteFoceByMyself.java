//https://www.naukri.com/code360/problems/sorted-array_6613259?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTabValue=PROBLEM

import java.util.*;
public class Solution {
    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here

        int i=0;
        int j=0;
        int k=0;

        int n = a.length;
        int m = b.length;
        int arr[] = new int[n + m];

        while(i < n && j < m)
        {
            if(a[i] < b[j])
            {
                arr[k] = a[i];
                i++;
                k++;
            }
            else
            {
                arr[k] = b[j];
                j++;
                k++;
            }
        }

        
        while(i < n)
        {
                arr[k] = a[i];
                i++;
                k++;
        }

        
        while(j < m)
        {
            
                arr[k] = b[j];
                j++;
                k++;
        }


        //arraylist tobe retur.
        List<Integer> al = new ArrayList<>();
        al.add(arr[0]);

        for(int p=1; p<arr.length; p++)
        {
            if(al.get(al.size() - 1) != arr[p])
            {
                al.add(arr[p]);
            }
        }

        return al;

    }
}