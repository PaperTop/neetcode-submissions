class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        double res = helper(x, Math.abs((long) n));
        return n < 0 ? 1 / res : res;
    }

    private double helper(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return helper(x * x, n/2);
        } else {
            return x * helper(x * x, (n - 1) / 2);
        }
    }
}
