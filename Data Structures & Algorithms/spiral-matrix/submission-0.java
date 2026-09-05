//Strategy keep track of visited and just go right if cant go forward anymore
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int d = 0;
        int count = 0;
        int[] pos = {0, 0};
        while (count != matrix.length * matrix[0].length) {
            visited[pos[0]][pos[1]] = true;
            res.add(matrix[pos[0]][pos[1]]);
            int nextA = pos[0] + dir[d][0], nextB = pos[1] + dir[d][1];
            if (nextA < 0 || nextA >= matrix.length || nextB < 0 || nextB >= matrix[0].length || visited[nextA][nextB]) {
                d = (d + 1) % 4;
            }
            pos[0] += dir[d][0];
            pos[1] += dir[d][1];
            count++;
        }

        return res;
    }
}
