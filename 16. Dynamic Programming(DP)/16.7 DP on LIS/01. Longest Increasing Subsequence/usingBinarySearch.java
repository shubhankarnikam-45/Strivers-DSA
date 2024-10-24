//question link.
//https://www.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
//https://leetcode.com/problems/longest-increasing-subsequence/description/

//this program solve using time complexity O(n * lon(n))
class usingBinarySearch {
    
    //creating function that gives the lower bound index.
    static int lowerBound(ArrayList<Integer> arr, int n, int target)
    {
        int low = 0;
        int high = n - 1;
        
        while(low <= high)
        {
            int mid = (low + high)/2;
            
            if(arr.get(mid) >= target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return low;
    }
    static int longestSubsequence(int n, int arr[]) {
        
        //creating arraylist.
        ArrayList<Integer> alist = new ArrayList<>();
        
        for(int i=0; i<n; i++)
        {
            //current element.
            int currElement = arr[i];
            
            int desiredIndex = lowerBound(alist, alist.size(), currElement);
            
            if(desiredIndex <= alist.size() - 1) alist.set(desiredIndex, currElement);
            else alist.add(currElement);
            
        }
        
        return alist.size();
        
      
        
    }
}