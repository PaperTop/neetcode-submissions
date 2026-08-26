class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent[i] = i; //n number of parents
            adj.add(new ArrayList<>()); //n empty lists
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int groups = n; 
        for (int i = 0; i < n; i++) {
            groups -= merge(parent, adj, i);
        }
        return groups;
    }

    private int merge(int[] parent, List<List<Integer>> adj, int node) {
        int merged = 0;
        parent[node] = findParent(parent, node);
        for (int nei : adj.get(node)) {
            int root = findParent(parent, nei);
            if (root != parent[node]) {
                parent[root] = parent[node];
                merged++;
            }
        }
        return merged;
    }

    private int findParent(int[] parent, int node) {
        int curr = parent[node];
        while (curr != parent[curr]) {
            curr = parent[curr];
        }
        return curr;
    }

    
}
