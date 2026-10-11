#Strategy: Bottom up approach
class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        words = set(dictionary)
        n = len(s)
        dp = [0] * (n + 1) # makes a list of n+1 0s

        for i in range (n - 1, - 1, - 1):
            dp[i] = 1 + dp[i + 1]
            for j in range (i, n):
                if s[i:j + 1] in words:
                    dp[i] = min(dp[i], dp[j + 1])
        return dp[0]