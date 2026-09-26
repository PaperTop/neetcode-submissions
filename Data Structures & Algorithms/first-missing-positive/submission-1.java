//Violates auxilary O(1) space rule but works
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> exist = new HashSet<>();
        for (int n : nums) {
            exist.add(n);
        }
        if (!exist.contains(1)) return 1;
        int smallest = Integer.MAX_VALUE;
        for (int n: nums) {
            if (!exist.contains(n + 1) && n + 1 > 0) {
                smallest = Math.min(smallest, n + 1);
            }
        }

        return smallest;
    }
}