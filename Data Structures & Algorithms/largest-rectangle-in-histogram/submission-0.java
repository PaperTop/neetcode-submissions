class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = 0;
            int right = 0;
            int currHeight = heights[i];

            while (true) {
                if (((i-(1 +left)) >= 0) && heights[i - (1 + left)] >= currHeight) {
                    left++;
                }
                else if (((i+(1+right)) < heights.length) && heights[i + (1 + right)] >= currHeight) {
                    right++;
                }
                else {
                    break;
                }
            }

            if ((currHeight * (1 + left + right)) > max) {
                max = currHeight * (1 + left + right);
            }
        }

        return max;
    }
}
