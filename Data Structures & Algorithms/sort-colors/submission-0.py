class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        reds = 0
        whites = 0

        for num in nums:
            if num == 0:
                reds += 1
            elif num == 1:
                whites += 1

        for i in range(reds):
            nums[i] = 0

        for i in range(reds, reds + whites):
            nums[i] = 1

        for i in range(reds + whites, len(nums)):
            nums[i] = 2