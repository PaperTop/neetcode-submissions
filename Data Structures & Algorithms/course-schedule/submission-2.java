class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Initialize prepMap with empty lists to not break
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        //Populate preMap with nodes
        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int crs) {
        //if we have played these games before there is a loop
        if (visiting.contains(crs)) {
            return false;
        }
        //reached the end
        if (preMap.get(crs).isEmpty()) {
            return true;
        }
        
        //mark as been here for future reference
        visiting.add(crs);
        //go through each course the current node is pointing to start a dfs on those nodes
        for (int pre : preMap.get(crs)) {
            if (!dfs(pre)) {
                return false;
            }
        }

        //backtrack slop
        visiting.remove(crs);
        //to not play the same games again and again - make visited nodes have empty pointers to quickly end those traversals if we enqueue those in the future
        preMap.put(crs, new ArrayList<>());
        
        return true;
    }
}
