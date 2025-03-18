//https://www.geeksforgeeks.org/problems/who-will-win-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=who-will-win

class Solution {
    static boolean searchInSorted(int arr[], int k) {
        
       int low = 0;
       int high = arr.length - 1;
       
       while(low <= high)
       {
           int mid = (high + low) / 2;
           if(arr[mid] == k) return true;
           
           if(arr[mid] < k)
           {
               low = mid + 1;
           }
           else
           {
      
class Solution {
    static boolean searchInSorted(int arr[], int k) {
        
       int low = 0;
       int high = arr.length - 1;
       
       while(low <= high)
       {
           int mid = (high + low) / 2;
           if(arr[mid] == k) return true;
           
           if(arr[mid] < k)
           {
               low = mid + 1;
           }
           else
           {
               high = mid - 1;
           }
       }
       
       return false;
    }
}         high = mid - 1;
           }
       }
       
       return false;
    }
}