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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Map<TreeNode, Integer> mp = new HashMap<>();
        mp.put(null, 0);
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();

            if (node.left != null && !mp.containsKey(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !mp.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                node = stack.pop();

                int left = mp.get(node.left);
                int right = mp.get(node.right);

                if (Math.abs(left - right) > 1) {
                    return false;
                }
                int height = 1 + Math.max(left, right);
                mp.put(node, height);
            }
        }
        return true;
    }
}
