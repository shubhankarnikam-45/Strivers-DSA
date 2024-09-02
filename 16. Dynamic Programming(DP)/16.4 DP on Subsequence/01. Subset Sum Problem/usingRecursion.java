//que link
//https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

//User function Template for Java

class Solution{


    static boolean fun(int idx, int arr[], int sum, int target)
    {
        if(idx == arr.length) return false;
        if(sum > target) return false;
        if(sum == target) return true;
        
        return (fun(idx + 1, arr, sum + arr[idx], target)) || (fun(idx + 1, arr, sum, target));
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        
        int dp[][] = new int[N][sum+1];
        return fun(0, arr, 0, sum);
    }
}