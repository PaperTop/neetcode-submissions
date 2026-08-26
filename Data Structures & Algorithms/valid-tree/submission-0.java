class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> nodes = new ArrayList<>();
        //populate nodes with empty list
        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<>());
        }
        //Populate the nodes with the edges
        for (int[] edge : edges) {
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
        }

        //pick any node and just grow outward checking if you ever touch the same thing twice while also keeping a counter
        boolean[] visited = new boolean[n];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,-1});
        visited[0] = true;
        n--;
        while (!q.isEmpty()) {
            int[] item = q.poll();
            int node = item[0];
            int parent = item[1];
            for (Integer branch : nodes.get(node)) {
                if (branch == parent) {
                    continue;
                } else if (visited[branch]) {
                    return false;
                } else {
                    q.offer(new int[]{branch, item[0]});
                    visited[branch] = true;
                    n--;
                }
            }
        } 
        return n == 0;
    }
}
