class Solution {
    public double myPow(double x, int n) {
        
        long m = n;
        long temp = m;
        m = Math.abs(m);

        double ans = 1.0;

        while( m > 0)
        {
            if(m % 2 == 0)
            {
                //even.
                x = x * x;
                m = m/2;
            }
            else
            {
                //odd.
                ans*=x;
                m = (m-1);
            }
        }

        if(temp < 0)
        {
            return 1.0/ans;
        }

        return ans;

    }
}