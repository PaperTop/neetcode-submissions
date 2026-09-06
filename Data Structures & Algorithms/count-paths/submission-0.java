class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(m, n, 0, 0) + 1;
    }

    private int dfs(int m, int n, int i, int j) {
        if (i == m - 1 || j == n - 1) {
            return 0;
        }

        return dfs(m, n, i + 1, j) + dfs(m, n, i, j + 1) + 1;
    }
}
