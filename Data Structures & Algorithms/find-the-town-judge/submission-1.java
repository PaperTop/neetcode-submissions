class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] node = new int[n];
        
        for (int[] t : trust) {
            node[t[1] - 1]++;
            node[t[0] - 1]--;
        }
        
        for (int i = 0; i < n; i++) {
            if (node[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}