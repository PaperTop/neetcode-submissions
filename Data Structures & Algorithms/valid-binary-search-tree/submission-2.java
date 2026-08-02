/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, -1001, root.val) && dfs(root.right, root.val, 1001);
    }

    private boolean dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        } else {
            int newMin = Math.min(min, root.val);
            int newMax = Math.min(max, root.val);
            return dfs(root.left, min, newMax) && dfs(root.right, newMin, max);
        }
    }
}
