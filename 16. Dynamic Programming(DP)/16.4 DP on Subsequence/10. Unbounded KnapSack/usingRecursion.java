//que link : 
//https://www.naukri.com/code360/problems/unbounded-knapsack_1215029?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION

public class usingRecursion {
    public static int fun(int index, int w, int profit[], int weight[])
    {
        //base case
        if(w == 0) return 0;
        
        if(index == 0)
        {
            if(weight[index] <= w)
            {
                int temp = w / weight[index];
                return temp * profit[index];
            }
            else return 0;
        }

        int notPick =  fun(index - 1, w, profit, weight);

        int pick = 0;
        if(weight[index] <= w)
        {
            pick = profit[index] + fun(index, w - weight[index], profit, weight);
        }

        return Math.max(notPick, pick);
    }
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        
        return fun(n-1, w, profit, weight);
    }
}
