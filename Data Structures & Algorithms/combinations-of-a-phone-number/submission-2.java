class Solution {
    
    //reduce stack overhead
    private static final String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        dfs(digits, res, cur, 0);
        
        return res;
    }

    private void dfs(String digits, List<String> res, StringBuilder cur, int idx) {
        //Base case to close
        if (idx == digits.length()) {
            res.add(cur.toString());
            return;
        }

        //branching out one two and three
        //removed .toCharArray() to use less memory
        for (int i = 0; i < map[digits.charAt(idx) - '0'].length(); i++) {
            char letter = map[digits.charAt(idx) - '0'].charAt(i);
            cur.append(letter);
            dfs(digits, res, cur, idx + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
