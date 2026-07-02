class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> maxes = new LinkedList<>();
        int l = 0, r = 0;

        while (r < nums.length) {
            while (!maxes.isEmpty() && nums[maxes.getLast()] < nums[r]) {
                maxes.removeLast();
            }
            maxes.addLast(r);
            
            if (l > maxes.getFirst()) {
                maxes.removeFirst();
            }

            if ((r + 1) >= k) {
                res[l] = nums[maxes.getFirst()];
                l++;
            }
            r++;
        }
        return res;

    }
}
