class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int n : piles) {
            max = Math.max(max, n);
        }

        
        int l = 1;
        int r = max;
        int mink = max;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int calculatedH = 0;
            
            for (int pile : piles) {
                calculatedH += (pile + m - 1) / m;
            }
            if (calculatedH > h) {
                l = m + 1;
            }
            else {
                mink = m;
                r = m - 1;
            }
        }
        return mink;
    }
}
