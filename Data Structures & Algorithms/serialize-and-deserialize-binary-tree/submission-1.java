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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "N";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder serial = new StringBuilder();
        
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                serial.append("N,");
            } else {
                serial.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return serial.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        if (tokens[0].equals("N")) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        int index = 1;
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!tokens[index].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(tokens[index]));
                queue.offer(node.left);
            }
            index++;
            if (!tokens[index].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(tokens[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }
}
