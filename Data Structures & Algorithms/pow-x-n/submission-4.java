class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;

        double res = 1;
        long power = Math.abs((long)n);

        while (power > 0) {
            //if odd
            if ((power & 1) == 1) {
                res *= x;
            }
            x *= x; // sqaure x
            power >>= 1; // divide by 2
        }
        
        return n < 0 ? 1 / res : res;
    }
}
