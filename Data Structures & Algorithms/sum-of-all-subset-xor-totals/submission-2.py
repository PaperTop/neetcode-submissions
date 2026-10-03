#The mask just represent the subsets, each bit of the mask corresponds with an index of nums. By going from 0 to n we will generate each subset.
class Solution:
    def subsetXORSum(self, nums):
        n = len(nums)
        total = 0
        for mask in range(1 << n):        # outer: one subset per mask
            x = 0
            for i in range(n):            # inner: one number at a time
                if mask & (1 << i):       # is nums[i] in this subset?
                    x ^= nums[i]
            total += x
        return total