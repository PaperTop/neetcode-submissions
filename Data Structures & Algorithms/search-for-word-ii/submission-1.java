class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
        int childCount = 0; // Tracks active children for pruning
    }
    
    private void populateTrie(TrieNode root, String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (char letter : word.toCharArray()) {
                int idx = letter - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                    curr.childCount++;
                }
                curr = curr.children[idx];
            }
            curr.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        populateTrie(root, words);

        List<String> res = new ArrayList<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, res);
            }
        }

        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode parent, List<String> res) {
        // 1. Boundary & Visited Check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '#') {
            return;
        }

        char letter = board[r][c];
        int idx = letter - 'a';
        TrieNode curr = parent.children[idx];

        // 2. Prune if no Trie branch exists
        if (curr == null) {
            return;
        }

        // 3. Collect Word
        if (curr.word != null) {
            res.add(curr.word);
            curr.word = null; // Avoid duplicate collection
        }

        // 4. CHOOSE (Mark visited in-place)
        board[r][c] = '#';

        // 5. EXPLORE 4 directions
        dfs(board, r - 1, c, curr, res);
        dfs(board, r + 1, c, curr, res);
        dfs(board, r, c - 1, curr, res);
        dfs(board, r, c + 1, curr, res);

        // 6. UN-CHOOSE / BACKTRACK
        board[r][c] = letter;

        // 7. OPTIMIZATION: Dynamic Trie Pruning!
        // If this node no longer has active children, remove it from the parent
        if (curr.childCount == 0) {
            parent.children[idx] = null;
            parent.childCount--;
        }
    }
}