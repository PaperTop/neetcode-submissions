//Stratey: kinda brute but use a hashset and go through string checking each substring and branching out if needed
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        for (String word : wordDict) {
            words.add(word);
        }

        return dfs(s, words);
    }

    private boolean dfs(String s, Set<String> words) {
        for (int i = 0; i < s.length() + 1; i++) {
            if (words.contains(s.substring(0, i))) {
                if (i == s.length()) {
                    return true;
                } else {
                    if (dfs(s.substring(i, s.length()), words)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
