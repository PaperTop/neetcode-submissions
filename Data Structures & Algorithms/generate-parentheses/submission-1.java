class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        int open = 0;
        int close = 0;
        dfs(res, cur, open, close, n);
        return res;
    }

    private void dfs(List<String> res, StringBuilder cur, int open, int close, int n) {
        if ((open + close) == 2*n) {
            res.add(new String(cur));
            return;
        } 
        if (open > close) {
            dfs(res, cur.append(')'), open, close + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (open < n) {
            dfs(res, cur.append('('), open + 1, close, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
