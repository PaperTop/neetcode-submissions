class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        dfs(s, res, cur, 0, 1);
        return res;
    }
    
    //basic split or don't split at each index backtrack
    private void dfs(String s, List<List<String>> res, List<String> cur, int last, int idx) {
        //base cases: at the end
        if (idx == s.length()) {
            if (isPalindrome(s.substring(last, idx))) {
                cur.add(s.substring(last, idx));
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }

        //yes split
        if (isPalindrome(s.substring(last, idx))) {
            cur.add(s.substring(last, idx));
            dfs(s, res, cur, idx, idx + 1);
            cur.remove(cur.size() - 1);
        }
        
        //no split    
        dfs(s, res, cur, last, idx + 1);
    }

    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
