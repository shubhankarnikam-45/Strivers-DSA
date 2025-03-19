//https://www.naukri.com/code360/problems/sorted-array_6613259?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTabValue=PROBLEM


iclass Solution {
    //function to check current element add or not.
    public static void checkAddOrNot(ArrayList<Integer> al, int a[], int i)
    {
        if(al.size()==0 || al.get(al.size() -1) != a[i])
            {
                al.add(a[i]);
            }
    }
    
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
         int i=0;
        int j=0;

        int n = a.length;
        int m = b.length;
        
        ArrayList<Integer> al = new ArrayList<>();


        while(i < n && j < m)
        {
            if(a[i] < b[j])
            {
                checkAddOrNot(al, a, i);
                i++;
            }
            else
            {
                checkAddOrNot(al, b, j);
                j++;
            }
        }

        
        while(i < n)
        {
                checkAddOrNot(al, a, i);
                i++;
        }

        
        while(j < m)
        {
            
                checkAddOrNot(al, b, j);
                j++;
        }


        return al;
    }
}


//here imporatant thing is how i acheive modularity by using function.