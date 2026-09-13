class CountSquares {
    Map<Integer, Map<Integer, Integer>> rowToCols;

    public CountSquares() {
        rowToCols = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        rowToCols.computeIfAbsent(x, k -> new HashMap<>()).put(y, rowToCols.get(x).getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point) {
        if (!rowToCols.containsKey(point[0])) return 0;
        int squares = 0;
        int x = point[0];
        int y = point[1];

        for (int newY : rowToCols.get(x).keySet()) {
            if (newY == y) continue;
            int dist = Math.abs(newY - y);

            int side = rowToCols.get(x).get(newY);
            int sideUp = rowToCols.containsKey(x - dist) ? rowToCols.get(x - dist).getOrDefault(newY, 0) : 0;
            int sideDown = rowToCols.containsKey(x + dist) ? rowToCols.get(x + dist).getOrDefault(newY, 0) : 0;
            int up = rowToCols.containsKey(x - dist) ? rowToCols.get(x - dist).getOrDefault(y, 0) : 0;
            int down = rowToCols.containsKey(x + dist) ? rowToCols.get(x + dist).getOrDefault(y, 0) : 0;

            //Check square upward and downward
            squares += side * sideUp * up + side * sideDown * down;
        }

        return squares;
    }
}
