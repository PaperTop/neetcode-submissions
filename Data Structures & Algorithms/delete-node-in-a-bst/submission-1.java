/*
I think what we have to do here is first find the node. After we find the node we can delete it. We also then must replace its position with something from one of its children.
Now the node can have 1 child or 2 children.
If 1 child we can just replace the current node with it.
Else if 2 children we will just replace it with it smaller child
repeat until there are no more children.
*/

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
        
        
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode sucessor = root.right;
            while (sucessor.left != null) {
                sucessor = sucessor.left;
            }
            root.val = sucessor.val;

            root.right = deleteNode(root.right, sucessor.val);
        }
        return root;
    }
}
