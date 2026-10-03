class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        def dfs(i, cur):
            if i == len(nums):
                return cur
            return dfs(i + 1, cur ^ nums[i]) + dfs(i + 1, cur)
        return dfs(0, 0)