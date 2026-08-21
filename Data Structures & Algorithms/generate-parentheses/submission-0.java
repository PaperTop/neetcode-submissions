class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String cur = "";
        int open = 0;
        int close = 0;
        dfs(res, cur, open, close, n);
        return res;
    }

    private void dfs(List<String> res, String cur, int open, int close, int n) {
        if ((open + close) == 2*n) {
            res.add(new String(cur));
            return;
        } 
        if (open > close) {
            dfs(res, cur + ')', open, close + 1, n);
        }
        if (open < n) {
            dfs(res, cur + '(', open + 1, close, n);
        }
    }
}
