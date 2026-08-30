//Use a trie to check substrings efficiently because making substrings is O(k)
class TrieNode {
    TrieNode[] children;
    boolean isWord;

    TrieNode(boolean word) {
        children = new TrieNode[26];
        isWord = word;
    }
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //Build trie tree
        TrieNode root = new TrieNode(false);
        for (String word : wordDict) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (cur.children[letter - 'a'] == null) {
                    cur.children[letter - 'a'] = new TrieNode(false);
                }
                cur = cur.children[letter - 'a'];
            }
            cur.isWord = true;
        }

        Boolean[] memo = new Boolean[s.length()];
        return dfs(s, root, 0, memo);
    }

    private boolean dfs(String s, TrieNode root, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }

        TrieNode cur = root;
        for (int i = start; i < s.length(); i++) {
            char letter = s.charAt(i);
            TrieNode nextCur = cur.children[letter - 'a'];

            if (nextCur == null) {
                break;
            }

            if (nextCur.isWord && dfs(s, root, i + 1, memo)){
                return true;
            }
            cur = nextCur;
        }
        return memo[start] = false;
    }
    
}
