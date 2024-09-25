import java.util.* ;
import java.io.*; 
public class usingSpaceOptimization {

    
    public static int minimumElements(int arr[], int x) {
        
        //length of array,
        int n = arr.length;

        int prev[] = new int[x + 1];
        
        



        for(int i=0; i<=x; i++)
        {
            if(i % arr[0] == 0) prev[i] = i/ arr[0];
            else prev[i]= 10000009;
        }

        for(int idx = 1; idx<n; idx++)
        {
            int cur[] = new int[x + 1];
        
            for(int target = 0; target <=x; target++)
            {
                    int notTake = 0 + prev[target];

                    int take = 0;
                    if(arr[idx] <= target)
                        take = 1 + cur[target - arr[idx]]; 
                    else 
                        take = 0 + prev[target];
                
                    cur[target] = Math.min(take, notTake);
            }

            prev = cur;
        }
        if(prev[x] == 10000009) return -1;
        else return prev[x];
    }

}