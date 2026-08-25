class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            nodes.get(pair[1]).add(pair[0]);
            indegrees[pair[0]] += 1;
        }

        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }
        
        int[] plan = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {
            List<Integer> node = nodes.get(q.peek());
            plan[idx] = q.poll();
            idx++;
            numCourses--;
            for (int edge : node) {
                indegrees[edge] -= 1;
                if (indegrees[edge] == 0) {
                    q.offer(edge);
                }
            }
        }

        if (numCourses == 0) {
            return plan;
        }
        return new int[0];
    }
}
