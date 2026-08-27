class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        
        int[] storage = new int[n + 1];
        storage[1] = 1;
        storage[2] = 2;
        int cur = 2;
        while (cur != n) {
            cur++;

            storage[cur] = storage[cur - 1] + storage[cur - 2];
        }
        
        return storage[n];
    }
}
