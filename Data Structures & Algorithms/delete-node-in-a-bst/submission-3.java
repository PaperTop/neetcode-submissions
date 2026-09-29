//Implementing iteration
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        TreeNode parent = null;
        TreeNode curr = root;
        while (curr != null && curr.val != key) {
            parent = curr;
            if (curr.val < key) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        if (curr == null) return root;

        if (curr.left == null && curr.right == null) {
            if (parent == null) {
                return null;
            }
            if (curr.val < parent.val) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (curr.left != null && curr.right == null) {
            if (parent == null) return curr.left;
            if (curr.val < parent.val) {
                parent.left = curr.left;
            } else {
                parent.right = curr.left;
            }
        } else if (curr.left == null && curr.right != null) {
            if (parent == null) return curr.right;
            if (curr.val < parent.val) {
                parent.left = curr.right;
            } else {
                parent.right = curr.right;
            }
        } else { //two children exist
            TreeNode pS = null;
            TreeNode s = curr.right;

            while (s.left != null) {
                pS = s;
                s = s.left;
            }
            //Reattach
            if (pS != null) {
                pS.left = s.right;
                s.right = curr.right;
            }
            s.left = curr.left;

            if (parent == null) return s;

            if (curr.val < parent.val) {
                parent.left = s;
            } else {
                parent.right = s;
            }
        }

        return root;
    }   
}