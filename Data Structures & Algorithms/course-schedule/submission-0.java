
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> nodes = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            int start = pair[1];
            int end = pair[0];
            nodes.get(start).add(end);
            indegree[end] += 1;
        }        

        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            List<Integer> node = nodes.get(q.poll());
            numCourses--;
            for (int edge : node) {
                if (indegree[edge] == 1) {
                    q.offer(edge);
                } else {
                    indegree[edge] -= 1;
                }
            }
        }
        



        return numCourses == 0;
    }
}
