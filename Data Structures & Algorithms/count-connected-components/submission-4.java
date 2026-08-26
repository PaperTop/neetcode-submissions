//Optimizations with ranking for further tree compression
class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i; //n number of parents
        }

        int groups = n; 

        for (int[] edge : edges) {
            int root1 = findParent(parent, edge[0]);
            int root2 = findParent(parent, edge[1]);

            if (root1 != root2) {

                // Make root1 the larger group
                if (size[root2] > size[root1]) {
                    int temp = root1;
                    root1 = root2;
                    root2 = temp;
                }

                // Put smaller group under larger group
                parent[root2] = root1;
                size[root1] += size[root2];

                groups--;
            }
        }
        return groups;
    }

    private int findParent(int[] parent, int node) {
        int curr = parent[node];
        while (curr != parent[curr]) {
            parent[curr] = parent[parent[curr]]; //slowly shrinks lookup
            curr = parent[curr];
        }
        return curr;
    }    
}

