class Solution {
    public int getSum(int a, int b) {
        int res = 0;
        int carry = 0;
        for (int i = 0; i < 32; i++) {
            int x = a & 1;
            a >>= 1;
            int y = b & 1;
            b >>= 1;
            int add = x + y + carry;
            if (add == 3) {
                res |= 1 << i;
            } else if (add == 2) {
                carry = 1;
            } else if (add == 1) {
                res |= 1 << i;
                carry = 0;
            }
        }
        return res;
    }
}
