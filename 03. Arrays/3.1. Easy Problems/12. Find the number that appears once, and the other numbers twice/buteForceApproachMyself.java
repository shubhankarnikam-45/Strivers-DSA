//question link.
//https://www.naukri.com/code360/problems/find-the-single-element_6680465?leftPanelTabValue=SUBMISSION
//https://leetcode.com/problems/single-number/description/

import java.util.*;
public class Solution {
    public static int getSingleElement(int []arr){
        
        //creating hashmap.
        Map<Integer, Integer> hmap = new HashMap<>();

        //traverse array and store the key-value pair.
        for(int i=0; i<arr.length; i++)
            hmap.put(arr[i], hmap.getOrDefault(arr[i],0)+1);

        //now we traverse and find key which value is 1 that is our answer.
        for(Map.Entry<Integer, Integer> entry : hmap.entrySet())
        {
            int key = entry.getKey();
            int value = entry.getValue();

            if(value == 1) return key;
        }

        //dummy return.
        return -11;

        
        
    }
}