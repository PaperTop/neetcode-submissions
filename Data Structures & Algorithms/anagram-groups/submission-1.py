class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = defaultdict(list)

        for s in strs:
            word = "".join(sorted(s))
            res[word].append(s)
        
        return list(res.values())