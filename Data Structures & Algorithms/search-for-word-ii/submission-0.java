class Solution {
    class TrieNode {
        
        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    public void populateTriePrefixTree(TrieNode root, String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (char letter : word.toCharArray()) {
                if (curr.children[letter - 'a'] == null) {
                    curr.children[letter - 'a'] = new TrieNode();
                }
                curr = curr.children[letter - 'a'];
            }
            curr.word = word;
        }
    }

    public void checkStart(char[][] board, boolean[][] visited, TrieNode node, int x, int y, List<String> res) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
            return;
        }
        
        char letter = board[x][y];
        TrieNode nextNode = node.children[letter - 'a'];
        if (nextNode == null) {
            return;
        }
        
        visited[x][y] = true;

        if (nextNode.word != null) {
            res.add(nextNode.word);
            nextNode.word = null;
        } 

        checkStart(board, visited, nextNode, x - 1, y, res);
        checkStart(board, visited, nextNode, x, y + 1, res);
        checkStart(board, visited, nextNode, x + 1, y, res);
        checkStart(board, visited, nextNode, x, y - 1, res);

        visited[x][y] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        populateTriePrefixTree(root, words);

        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                checkStart(board, visited, root, i, j, res);
            }
        }

        return res;
    }
}
