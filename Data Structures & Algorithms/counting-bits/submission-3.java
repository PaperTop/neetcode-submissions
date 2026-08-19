class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        int off = 1;

        for (int i = 1; i <= n; i++) {
            if (off * 2 == i) {
                off = i;
            }
            res[i] = 1 + res[i - off];
        }
        return res;
    }
}
