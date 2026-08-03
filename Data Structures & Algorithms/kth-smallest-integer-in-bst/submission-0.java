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
    List<TreeNode> nodes = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);        
        return nodes.get(k - 1).val;
    }

    private void dfs(TreeNode node) {
        if (node.left != null) {
            dfs(node.left);
        }
        nodes.add(node);
        if (node.right != null) {
            dfs(node.right);
        }
    }
}
