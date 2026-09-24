class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        
        long num = 1;
        while (true) {
            if (num * num > x) {
                return (int)(num - 1);
            }
            num++;
        }
    }
}