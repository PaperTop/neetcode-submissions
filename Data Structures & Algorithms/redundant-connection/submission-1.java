class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] size = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[] res = {-1, -1};
        
        for (int[] edge : edges) {
            int root1 = findRoot(parent, edge[0]);
            int root2 = findRoot(parent, edge[1]);
            
            //check if the same group if so add to res and skip
            if (root1 == root2) {
                res = edge;
                continue;
            }
            //if two different groups merge the smaller one under
            if (size[root1] > size[root2]) {
                parent[root2] = root1;
                size[root1] += size[root2];
            } else {
                parent[root1] = root2;
                size[root2] += size[root1];
            }
        }

        return res;
    }

    private int findRoot(int[] parent, int node) {
        int cur = node;
        while (cur != parent[cur]) {
            parent[cur] = parent[parent[cur]]; //compress tree
            cur = parent[cur];
        }
        return cur;
    }
}
