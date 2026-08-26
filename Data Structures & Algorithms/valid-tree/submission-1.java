class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        if (!dfs(adj, visited, 0, -1)) {
            return false;
        }

        for (boolean status : visited) {
            if (!status) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adj, boolean[] visited, int node, int parent) {
        if (visited[node]) {
            return false;
        }

        visited[node] = true;
        for (int nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (!dfs(adj, visited, nei, node)) {
                return false;
            }
        }
        return true;
    }
}
