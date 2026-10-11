#Strategy: Our recurssive solution decided if we should skip this character adding one or consider all the possible strings that could start at this position. However that resulted in calculations being performed multiple because if we had skipped ahead we would have calculated at certain positions already, so by having a memo we avoid that saving our results and avoid calculating stuff multiple times.
class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        words = set(dictionary)
        dp = {len(s): 0}

        def dfs(i):
            if i in dp:
                return dp[i]
            res = 1 + dfs(i + 1)
            for j in range (i, len(s)):
                if s[i:j + 1] in words:
                    res = min(res, dfs(j + 1))
            dp[i] = res;
            return res
        return dfs(0)