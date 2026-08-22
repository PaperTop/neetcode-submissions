class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        dfs(digits, map, res, cur, 0);
        
        return res;
    }

    private void dfs(String digits, String[] map, List<String> res, StringBuilder cur, int idx) {
        //Base case to close
        if (idx == digits.length()) {
            res.add(new String(cur));
            return;
        }

        //branching out one two and three
        for (char letter : map[digits.charAt(idx) - '0'].toCharArray()) {
            cur.append(letter);
            dfs(digits, map, res, cur, idx + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
