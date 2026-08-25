class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? 1 : -1;

        if (x > 0) {
            x = -x;
        }

        int res = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (res < Integer.MIN_VALUE / 10 ||
                (res == Integer.MIN_VALUE / 10 && digit < Integer.MIN_VALUE % 10)) {
                return 0;
            }

            res = res * 10 + digit;
        }

        if (sign == -1) {
            if (res == Integer.MIN_VALUE) {
                return 0;
            }
            return -res;
        }

        return res;
    }
}
