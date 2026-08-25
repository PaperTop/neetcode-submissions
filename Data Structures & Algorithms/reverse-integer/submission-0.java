class Solution {
    public int reverse(int x) {
        final int MIN = -2147483648; // -2^31
        final int MAX = 2147483647;  // 2^31 - 1

        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10; 

            //Check if value is going over
            if (res > MAX / 10 || (res == MAX / 10 && digit > MAX % 10)) {
                return 0;
            }
            //Check if value is going under
            if (res < MIN / 10 || (res == MIN / 10 && digit < MIN % 10)) {
                return 0;
            }

            //Add the digit to soln
            res = (res * 10) + digit;
        }
        return res;
    }
}
